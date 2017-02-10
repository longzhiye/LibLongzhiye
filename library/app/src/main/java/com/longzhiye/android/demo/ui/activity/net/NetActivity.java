package com.longzhiye.android.demo.ui.activity.net;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.longzhiye.android.demo.R;
import com.longzhiye.android.demo.model.bean.BeanA;
import com.longzhiye.android.demo.model.bean.BeanB;
import com.longzhiye.android.demo.model.bean.BeanC;
import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.model.http.HttpUtil;
import com.longzhiye.android.lib.model.http.callback.FileDownloadHttpCallback;
import com.longzhiye.android.lib.model.http.callback.ListCallback;
import com.longzhiye.android.lib.model.http.callback.ObjectCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

/**
 * 网络请求
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 15:22
 */
public class NetActivity extends AppCompatActivity {

    private final String TAG = NetActivity.class.getSimpleName();

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Button btnDownload;
    private TextView tv4;

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;

    private String url = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        initView();
        initListener();
        loadObject();
        loadList();
        HttpUtil.getInstance().loadImage(this, url, iv1);
        HttpUtil.getInstance().loadImage(this, url, iv2, true);
        HttpUtil.getInstance().loadImage(this, url, iv3, 20);
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        btnDownload = (Button) findViewById(R.id.btn_download);
        tv4 = (TextView) findViewById(R.id.tv4);

        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
    }

    private void initListener() {
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFileByNet();
            }
        });
    }

    private void loadObject() {
        HttpUtil.getInstance().sendPost(this, "http://www.qukancai.com:8902/beauty/home/index", new JSONObject(), BeanC.class, new ObjectCallback<BeanC>() {

            @Override
            public void onResponse(BeanC response) {
                LogUtil.d(TAG, response.getViewpoint().get(0).getTitle());
                tv1.setText(response.toString());
            }

            @Override
            public void onError(Context context, int errorCode) {

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
        HttpUtil.getInstance().sendPost(this, "http://www.qukancai.com:8902/beauty/system/login", params, BeanA.class, new ObjectCallback<BeanA>() {

            @Override
            public void onResponse(BeanA response) {
                token[0] = response.getToken();
                LogUtil.d(TAG, token[0]);
                tv2.setText(response.toString());
            }

            @Override
            public void onError(Context context, int errorCode) {

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
        HttpUtil.getInstance().sendPost(this, "http://www.qukancai.com:8902/beauty/investAdviser/list", params3, BeanB.class, new ListCallback<BeanB>() {


            @Override
            public void onResponse(List<BeanB> response) {
                tv3.setText(response.toString());
                if (page == 1) {

                } else {

                }
                response.get(0).getAvatar();
            }

            @Override
            public void onError(Context context, int errorCode) {

            }


        });
    }

    private void downloadFileByNet() {
        String url = "https://downpack.baidu.com/appsearch_AndroidPhone_1012271b.apk";
        HttpUtil.getInstance().downloadFile(NetActivity.this, url, new FileDownloadHttpCallback() {
            @Override
            public void onProgress(long byteCount, long contentLength, boolean done) {
                LogUtil.d(TAG, "byteCount:" + byteCount + ",contentLength:" + contentLength + ",done:" + done);
                tv4.setText("byteCount:" + byteCount + ",contentLength:" + contentLength + ",done:" + done);
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
            public void onError(Context context, int errorCode) {

            }
        });
    }

}
