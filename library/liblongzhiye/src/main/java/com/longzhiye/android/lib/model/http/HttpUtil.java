package com.longzhiye.android.lib.model.http;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.longzhiye.android.lib.common.util.FileUtil;
import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.config.AppConfig;
import com.longzhiye.android.lib.model.http.body.ProgressResponseBody;
import com.longzhiye.android.lib.model.http.callback.BaseCallback;
import com.longzhiye.android.lib.model.http.callback.FileDownloadHttpCallback;
import com.longzhiye.android.lib.model.http.callback.ListCallback;
import com.longzhiye.android.lib.model.http.callback.ObjectCallback;
import com.longzhiye.android.lib.model.http.glide.transform.GlideCircleTransform;
import com.longzhiye.android.lib.model.http.glide.transform.GlideRoundTransform;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 网络请求类
 * Author: longzhiye
 * Date: 16-05-25
 * Time: 10:50
 */
public class HttpUtil {

    private final String TAG = HttpUtil.class.getSimpleName();

    private static HttpUtil mInstance;
    private OkHttpClient okHttpClient;
    // 主线程
    private Handler mDelivery;

    private HttpUtil() {
        okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(AppConfig.NET_TIME_OUT, TimeUnit.SECONDS);//设置超时时间
        mDelivery = new Handler(Looper.getMainLooper());

    }

    public static HttpUtil getInstance() {
        if (mInstance == null) {
            synchronized (HttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new HttpUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 取消网络连接
     *
     * @param context
     */
    public void cancelNet(Context context) {
        okHttpClient.cancel(context);
    }

    /**
     * 发送get请求(不带参数)
     *
     * @param context
     * @param url
     * @param tClass
     * @param baseCallback
     */
    public void sendGet(@NonNull Context context, @NonNull String url, final Class<?> tClass,
                        @NonNull final BaseCallback baseCallback) {
        sendGet(context, url, null, tClass, baseCallback);
    }


    /**
     * 发送get请求(带参数)
     *
     * @param context
     * @param url
     */
    public void sendGet(@NonNull Context context, @NonNull String url, Map<String, String> params, final Class<?> tClass,
                        @NonNull final BaseCallback baseCallback) {
        if (params != null) {
            // 组装url和参数
            url = getEncodedUrl(url, params);
        }
        LogUtil.d(TAG, url);
        Request request = new Request.Builder()
                .url(url)
                .tag(context)
                .build();
        responseCallback(context, tClass, request, baseCallback);
    }

    /**
     * 组装get请求的url和参数
     *
     * @param url
     * @param params
     * @return
     */
    private String getEncodedUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append(url).append("?");
        // 拼接参数
        Iterator iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            try {
                // 进行url编码
                key = URLEncoder.encode(key, "UTF-8");
                val = URLEncoder.encode(val, "UTF-8");
                builder.append(key).append("=").append(val).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String result = builder.toString();
        int len = result.length();

        return result.substring(0, len - 1);
    }


    /**
     * 发送post请求(不带参数)
     *
     * @param context
     * @param url
     * @param tClass
     * @param baseCallback
     */
    public void sendPost(Context context, String url, final Class<?> tClass,
                         @NonNull final BaseCallback baseCallback) {
        sendPost(context, url, null, tClass, baseCallback);
    }

    /**
     * 发送post请求(带参数)
     *
     * @param context
     * @param url
     * @param params
     * @param baseCallback
     */
    public void sendPost(@NonNull final Context context, @NonNull String url, JSONObject params, final Class<?> tClass,
                         @NonNull final BaseCallback baseCallback) {
        if (null == params) {
            params = new JSONObject();
        }
        LogUtil.d(TAG, url + params.toString());
        // 组装请求参数
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());
        //
        final Request request = new Request.Builder()
                .url(url)// 请求地址
                .post(requestBody)// 参数
                .tag(context)// 标签
                .build();
        responseCallback(context, tClass, request, baseCallback);

    }

    /**
     * 请求返回处理
     *
     * @param context
     * @param tClass
     * @param request
     * @param baseCallback
     */
    private void responseCallback(final Context context, final Class<?> tClass, Request request, final BaseCallback baseCallback) {
        // 开始请求
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String responseResult = response.body().string();
                LogUtil.d(TAG, responseResult);
                if (response.isSuccessful()) {
                    if (baseCallback instanceof ObjectCallback) {// 返回object
                        baseCallback.setmClass(tClass);
                        try {
                            // 返回的数据统一用json格式接收
                            JSONObject jsonObject = new JSONObject(responseResult);
                            if (jsonObject.getInt(AppConfig.RESPONSE_CODE_NAME) == AppConfig.RESPONSE_SUCCESS_CODE) {// App服务器的返回码是否为约定的成功返回码
                                // 转换数据
                                final Object object = ((ObjectCallback) baseCallback).parseNetworkResponse(jsonObject.getJSONObject(AppConfig.RESPONSE_DATA_NAME).toString());
                                // 将得到的数据返回到主线程中
                                mDelivery.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        baseCallback.onEnd();
                                        ((ObjectCallback) baseCallback).onResponse(object);
                                    }
                                });
                            } else {// 返回App服务器的错误返回码
                                onFailDelivery(baseCallback, context, jsonObject.getInt(AppConfig.RESPONSE_CODE_NAME));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (baseCallback instanceof ListCallback) {// 返回list
                        baseCallback.setmClass(tClass);
                        try {
                            JSONObject jsonObject = new JSONObject(responseResult);
                            if (jsonObject.getInt(AppConfig.RESPONSE_CODE_NAME) == AppConfig.RESPONSE_SUCCESS_CODE) {
                                final Object object = ((ListCallback) baseCallback).parseNetworkResponse(jsonObject.getJSONArray(AppConfig.RESPONSE_DATA_NAME).toString());
                                mDelivery.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (object instanceof List) {
                                            baseCallback.onEnd();
                                            List list = (List) object;
                                            ((ListCallback) baseCallback).onResponse(list);
                                        }
                                    }
                                });
                            } else {// 返回App服务器的错误返回码
                                onFailDelivery(baseCallback, context, jsonObject.getInt(AppConfig.RESPONSE_CODE_NAME));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {// 返回string
                        onSuccessDelivery(baseCallback, responseResult);
                    }
                } else {// 请求错误
                    LogUtil.d(TAG, "网络错误代码:" + response.code() + ",网络错误信息:" + response.message());
                    onFailDelivery(baseCallback, context, response.code());
                }
            }

        });
    }

    /**
     * 开始请求
     *
     * @param callback
     */
    private void onStartDelivery(final BaseCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onStart();
            }
        });
    }

    /**
     * 请求成功返回字符串
     *
     * @param callback
     * @param result
     */
    private void onSuccessDelivery(final BaseCallback callback, final String result) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onEnd();
                callback.onResponse(result);
            }
        });
    }

    /**
     * 请求失败返回错误码
     *
     * @param callback
     * @param context
     * @param errorCode
     */
    private void onFailDelivery(final BaseCallback callback, final Context context, final int errorCode) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onEnd();
                callback.onError(context, errorCode);
            }
        });
    }

    private void onDownloadSuccessDelivery(final FileDownloadHttpCallback callback, final File file) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onEnd();
                callback.onResponse(file);
            }
        });
    }

    /**
     * 多文件上传(post表单方式提交)
     *
     * @param context
     * @param url
     * @param files
     * @param params
     * @param tClass
     * @param baseCallback
     */
    public void uploadFiles(Context context, String url, Map<String, String> files, JSONObject params, final Class<?> tClass,
                            final BaseCallback baseCallback) {
        LogUtil.d(TAG, url + (params == null ? "" : params.toString()) + (files == null ? "" : files.toString()));
        Request request = buildMultipartFormRequest(context, url, files, params);
        responseCallback(context, tClass, request, baseCallback);

    }

    /**
     * 单文件文件上传带参数(post表单方式提交)
     *
     * @param context
     * @param url
     * @param filePath
     * @param params
     * @param tClass
     * @param baseCallback
     */
    public void uploadSingleFile(Context context, String url, String filePath, JSONObject params, final Class<?> tClass,
                                 final BaseCallback baseCallback) {
        Map<String, String> temp = null;
        if (filePath != null) {
            temp = new HashMap();
            temp.put("file", filePath);
        }
        uploadFiles(context, url, temp, params, tClass, baseCallback);
    }

    /**
     * 编译表单请求
     *
     * @param context
     * @param url
     * @param files   文件
     * @param params  参数
     * @return
     */
    private Request buildMultipartFormRequest(Context context, String url, Map<String, String> files, JSONObject params) {
        // 提交类型为表单提交
        MultipartBuilder builder = new MultipartBuilder()
                .type(MultipartBuilder.FORM);

        if (params != null) {
            // 表单提交同时添加参数
            Iterator it = params.keys();
            while (it.hasNext()) {
                try {
                    String key = it.next().toString();
                    String value = params.getString(key);
                    builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""),
                            RequestBody.create(null, value));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        // 添加多个文件
        if (files != null) {
            RequestBody fileBody = null;
            for (String key : files.keySet()) {
                String value = files.get(key);
                File file = new File(value);
                String fileName = file.getName();
                fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);
                // 根据文件名设置contentType
                builder.addPart(Headers.of("Content-Disposition",
                        "form-data; name=\"" + key + "\"; filename=\"" + fileName + "\""),
                        fileBody);
            }
        }

        RequestBody requestBody = builder.build();
        return new Request.Builder()
                .url(url)// 请求地址
                .post(requestBody)// 参数
                .tag(context)// 标签
                .build();
    }

    /**
     * 获取图片类型
     *
     * @param path
     * @return
     */
    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    /**
     * 下载文件
     *
     * @param context
     * @param url
     * @param callback
     */
    public void downloadFile(final Context context, final String url, final FileDownloadHttpCallback callback) {
        HashMap<String, String> headers = null;
        HashMap<String, String> params = null;
//        HashMap<String, String> headers = customRequest.getHeaders();
//        HashMap<String, String> params = customRequest.getParams();

//        final String url = customRequest.getUrl();
//        String tag = customRequest.getTag();

        Request.Builder builder = new Request.Builder();
        builder.url(url);
//        builder.cacheControl(CacheControl.FORCE_NETWORK);
//        if (!TextUtils.isEmpty(tag)) {
//            builder.tag(tag);
//        }

        // 添加头部
        if (headers != null && headers.size() > 0) {
            Iterator iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                builder.addHeader(key, val);
            }
        }

//        //Add Post Params
//        if (params != null && params.size() > 0) {
//            builder.post(getRequestBody(params));
//        }

        Request request = builder.tag(context).build();
        // 开始请求
        onStartDelivery(callback);

        OkHttpClient client = addDownloadInterceptor(okHttpClient, callback);
        // 设置连接时间
        client.setConnectTimeout(30, TimeUnit.SECONDS);
        // 设置写入时间
        client.setWriteTimeout(30, TimeUnit.SECONDS);
        // 设置读取时间
        client.setReadTimeout(30, TimeUnit.SECONDS);

//        if (!TextUtils.isEmpty(tag)) {
//            mDownloadMap.put(tag, client);
//        }
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        callback.onEnd();
                        // 下载完成写入sd卡
                        File file = FileUtil.writeFile(response.body().byteStream(),
                                AppConfig.PROJECT_DOWNLOAD_PATH
                                        + url.substring(url.lastIndexOf("/") + 1), false);
                        // 返回成功
                        onDownloadSuccessDelivery(callback, file);
                    } catch (Exception e) {
                        e.printStackTrace();
                        onFailDelivery(callback, context, AppConfig.RESPONSE_ERROR_DOWN_FILE_ERROR);
                    }
                } else {
                    LogUtil.d(TAG, "网络错误代码:" + response.code() + ",网络错误信息:" + response.message());
                    onFailDelivery(callback, context, response.code());
                }
            }
        });
    }

    /**
     * 添加下载拦截器
     *
     * @param client
     * @param progressListener
     * @return
     */
    private OkHttpClient addDownloadInterceptor(OkHttpClient client, final FileDownloadHttpCallback progressListener) {
        //克隆
        OkHttpClient clone = client.clone();
        //增加拦截器
        clone.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response originalResponse = chain.proceed(chain.request());
                //包装响应体并返回
                return originalResponse.newBuilder()
                        .body(new ProgressResponseBody(originalResponse.body(), progressListener, mDelivery))
                        .build();
            }
        });
        return clone;
    }

    /**
     * 加载图片
     *
     * @param url
     * @param imageView
     */
    public void loadImage(Context context, String url, ImageView imageView) {
        loadImage(context, url, imageView, null, null);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param isCircle  是否圆角
     */
    public void loadImage(Context context, String url, ImageView imageView, boolean isCircle) {
        loadImage(context, url, imageView, isCircle, null);
    }

    /**
     * 加载圆角矩形图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param roundDP   裁剪角度
     */
    public void loadImage(Context context, String url, ImageView imageView, Integer roundDP) {
        loadImage(context, url, imageView, null, roundDP);
    }

    /**
     * @param context
     * @param url
     * @param imageView
     * @param isCircle
     * @param roundDP
     */
    private void loadImage(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView, Boolean isCircle, Integer roundDP) {
        if (isCircle != null && isCircle == true) {// 圆形图片
            Glide.with(context).load(url).transform(new GlideCircleTransform(context)).into(imageView);
        } else if (roundDP != null) {// 圆角矩形图片
            Glide.with(context).load(url).transform(new GlideRoundTransform(context, roundDP)).into(imageView);
        } else {
            Glide.with(context).load(url).into(imageView);
        }
    }

}
