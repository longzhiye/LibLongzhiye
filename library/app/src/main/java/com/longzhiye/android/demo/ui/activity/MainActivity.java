package com.longzhiye.android.demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.longzhiye.android.demo.R;
import com.longzhiye.android.demo.ui.activity.net.NetActivity;
import com.longzhiye.android.demo.ui.activity.pulltorefresh.PulltorefreshActivity;
import com.longzhiye.android.demo.ui.activity.selectimg.SelectImgActivity;
import com.longzhiye.android.demo.ui.activity.titlebar.TitleBarActivity;

/**
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 15:02
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab;

    // 网络请求
    private Button btnNet;
    // 标题栏
    private Button btnTitleBar;
    // 下拉刷新
    private Button btnPulltorefresh;
    // 图片选择
    private Button btnSelectimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        initListener();
    }

    private void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        btnNet = (Button) findViewById(R.id.btn_net);
        btnTitleBar = (Button) findViewById(R.id.btn_title_bar);
        btnPulltorefresh = (Button) findViewById(R.id.btn_pulltorefresh);
        btnSelectimg = (Button) findViewById(R.id.btn_selectimg);
    }

    private void initListener() {
        fab.setOnClickListener(this);
        btnNet.setOnClickListener(this);
        btnTitleBar.setOnClickListener(this);
        btnPulltorefresh.setOnClickListener(this);
        btnSelectimg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.btn_net:
                startActivity(new Intent(MainActivity.this, NetActivity.class));
                break;
            case R.id.btn_title_bar:
                startActivity(new Intent(MainActivity.this, TitleBarActivity.class));
                break;
            case R.id.btn_pulltorefresh:
                startActivity(new Intent(MainActivity.this, PulltorefreshActivity.class));
                break;
            case R.id.btn_selectimg:
                startActivity(new Intent(MainActivity.this, SelectImgActivity.class));
                break;
        }
    }
}
