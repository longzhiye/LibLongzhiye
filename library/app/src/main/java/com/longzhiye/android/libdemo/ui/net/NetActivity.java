package com.longzhiye.android.libdemo.ui.net;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.model.http.HttpUtil;
import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.libdemo.R;
import com.longzhiye.android.libdemo.model.bean.BeanA;
import com.longzhiye.android.libdemo.model.bean.BeanB;
import com.longzhiye.android.libdemo.model.bean.BeanC;

import java.util.List;

/**
 * 网络请求
 * Author: longzhiye
 * Date: 17/3/8
 * Time: 上午8:53
 * Email: longzhiye163@163.com
 */
public class NetActivity extends TitleBarBaseActivity implements NetMvpView {

    private static final String TAG = NetActivity.class.getSimpleName();

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Button btnDownload;
    private TextView tv4;

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;

    private NetPresenter netPresenter;

    private String url = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    public int setContentContainer() {
        return R.layout.activity_net;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("网络请求");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();

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
                netPresenter.downloadFileByNet();
            }
        });
    }

    private void initData() {
        netPresenter = new NetPresenter();
        netPresenter.attachView(this, this);
    }

    @Override
    public void showObject(BeanC response) {
        LogUtil.d(TAG, response.getViewpoint().get(0).getTitle());
        tv1.setText(response.toString());
    }

    @Override
    public void showList(BeanA response) {

        tv2.setText(response.toString());
    }

    @Override
    public void showList2(List<BeanB> response) {
        tv3.setText(response.toString());
//        if (page == 1) {
//
//        } else {
//
//        }
//        response.get(0).getAvatar();
    }

    @Override
    public void showDownloadFile(long byteCount, long contentLength, boolean done) {
        LogUtil.d(TAG, "byteCount:" + byteCount + ",contentLength:" + contentLength + ",done:" + done);
        tv4.setText("byteCount:" + byteCount + ",contentLength:" + contentLength + ",done:" + done);
    }
}
