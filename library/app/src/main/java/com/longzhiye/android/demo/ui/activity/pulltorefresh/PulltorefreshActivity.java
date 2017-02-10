package com.longzhiye.android.demo.ui.activity.pulltorefresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.longzhiye.android.demo.R;

/**
 * 下拉刷新,上拉加载更多
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 17:21
 */
public class PulltorefreshActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltorefresh);

        findViewById(R.id.btn_listview).setOnClickListener(this);
        findViewById(R.id.btn_gridview).setOnClickListener(this);
        findViewById(R.id.btn_scrollview).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_listview:
                startActivity(new Intent(PulltorefreshActivity.this, PullListViewActivity.class));
                break;
            case R.id.btn_gridview:
                startActivity(new Intent(PulltorefreshActivity.this, PullGridViewActivity.class));
                break;
            case R.id.btn_scrollview:
                startActivity(new Intent(PulltorefreshActivity.this, PullScrollViewActivity.class));
                break;
            case R.id.btn_recyclerview:
                startActivity(new Intent(PulltorefreshActivity.this, PullReyclerViewActivity.class));
                break;
        }
    }
}
