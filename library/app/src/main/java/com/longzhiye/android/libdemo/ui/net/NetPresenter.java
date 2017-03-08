package com.longzhiye.android.libdemo.ui.net;

import android.content.Context;

import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.model.http.HttpUtil;
import com.longzhiye.android.lib.model.http.callback.FileDownloadHttpCallback;
import com.longzhiye.android.lib.model.http.callback.ListCallback;
import com.longzhiye.android.lib.model.http.callback.ObjectCallback;
import com.longzhiye.android.lib.ui.base.BasePresenterImpl;
import com.longzhiye.android.libdemo.model.bean.BeanA;
import com.longzhiye.android.libdemo.model.bean.BeanB;
import com.longzhiye.android.libdemo.model.bean.BeanC;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

/**
 * 网络请求
 * Author: longzhiye
 * Date: 17/3/8
 * Time: 上午9:01
 * Email: longzhiye163@163.com
 */
public class NetPresenter extends BasePresenterImpl<NetMvpView>{

    private static final String TAG = NetPresenter.class.getSimpleName();

    @Override
    public void attachView(NetMvpView mvpView, Context context) {
        super.attachView(mvpView, context);
        loadObject();
        loadList();
    }

    private void loadObject() {
        HttpUtil.getInstance().sendPost(getContext(), "http://www.qukancai.com:8902/beauty/home/index", BeanC.class, new ObjectCallback<BeanC>() {

            @Override
            public void onResponse(BeanC response) {
                getMvpView().showObject(response);

            }

            @Override
            public void onError(Context context, int errorCode, String errorTip) {

            }


        });
    }

    private Integer page = 1;

    private void loadList() {
        final String[] token = {null};
        JSONObject params = new JSONObject();
        try {
            params.put("mobile", "18965812341");
            params.put("password", "c81e728d9d4c2f636f067f89cc14862c");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.getInstance().sendPost(getContext(), "http://www.qukancai.com:8902/beauty/system/login", params, BeanA.class, new ObjectCallback<BeanA>() {

            @Override
            public void onResponse(BeanA response) {
                token[0] = response.getToken();
                LogUtil.d(TAG, token[0]);
                getMvpView().showList(response);
            }

            @Override
            public void onError(Context context, int errorCode, String errorTip) {

            }



        });

        JSONObject params3 = new JSONObject();
        try {
            params3.put("page", page);
            params3.put("page_size", 100);
            params3.put("order", 1);
            params3.put("token", token);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.getInstance().sendPost(getContext(), "http://www.qukancai.com:8902/beauty/investAdviser/list", params3, BeanB.class, new ListCallback<BeanB>() {


            @Override
            public void onResponse(List<BeanB> response) {
                getMvpView().showList2(response);
            }

            @Override
            public void onError(Context context, int errorCode, String errorTip) {

            }


        });
    }

    public void downloadFileByNet() {
        String url = "https://downpack.baidu.com/appsearch_AndroidPhone_1012271b.apk";
        HttpUtil.getInstance().downloadFile(getContext(), url, new FileDownloadHttpCallback() {
            @Override
            public void onProgress(long byteCount, long contentLength, boolean done) {
                getMvpView().showDownloadFile(byteCount,contentLength,done);
            }

            @Override
            public File parseNetworkResponse(String result) throws Exception {
                return null;
            }

            @Override
            public void onResponse(File response) {
                LogUtil.d(TAG, "onResponse:" + response.getPath());

            }

            @Override
            public void onError(Context context, int errorCode, String errorTip) {

            }
        });
    }

}
