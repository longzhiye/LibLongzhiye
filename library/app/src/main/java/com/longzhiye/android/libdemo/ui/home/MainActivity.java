package com.longzhiye.android.libdemo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.longzhiye.android.lib.ui.activity.BaseActivity;
import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.libdemo.R;

/**
 * 主界面
 * Author: longzhiye
 * Date: 17/3/7
 * Time: 下午3:14
 * Email: longzhiye163@163.com
 */
public class MainActivity extends TitleBarBaseActivity implements MainMvpView, View.OnClickListener {

    // 网络请求
    private Button btnNet;
    // 标题栏
    private Button btnTitleBar;
    // 下拉刷新
    private Button btnPulltorefresh;
    // 图片选择
    private Button btnSelectimg;
    // 权限
    private Button btnPermissions;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }

    @Override
    public int setContentContainer() {
        return R.layout.activity_main;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("LibDemo");
        return true;
    }

    private void initView() {
        btnNet = (Button) findViewById(R.id.btn_net);
        btnTitleBar = (Button) findViewById(R.id.btn_title_bar);
        btnPulltorefresh = (Button) findViewById(R.id.btn_pulltorefresh);
        btnSelectimg = (Button) findViewById(R.id.btn_selectimg);
        btnPermissions = (Button) findViewById(R.id.btn_permissions);
    }

    private void initListener() {
        btnNet.setOnClickListener(this);
        btnTitleBar.setOnClickListener(this);
        btnPulltorefresh.setOnClickListener(this);
        btnSelectimg.setOnClickListener(this);
        btnPermissions.setOnClickListener(this);
    }

    private void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_net:
                mainPresenter.switchNetView();
                break;
            case R.id.btn_title_bar:
                mainPresenter.switchTitleBarView();
                break;
            case R.id.btn_pulltorefresh:
                mainPresenter.switchPullToRefreshView();
                break;
            case R.id.btn_selectimg:
                mainPresenter.switchSelectImgView();
                break;
            case R.id.btn_permissions:
                mainPresenter.switchPermissionsView();
                break;
        }
    }
}
