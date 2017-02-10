package com.longzhiye.android.demo.ui.activity.pulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.longzhiye.android.demo.R;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MySwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉刷新,上拉加载更多ScrollView
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 17:24
 */
public class PullScrollViewActivity extends AppCompatActivity {

    private MySwipeRefreshLayout msr;
    private ScrollView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_scrollview);

        msr = (MySwipeRefreshLayout) findViewById(R.id.msr);
        sv = (ScrollView) findViewById(R.id.sv);

        msr.setMyOnRefreshListener(new MyOnRefreshListener() {
            @Override
            public void onHeadRefresh() {
                msr.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                msr.setRefreshing(false);
                            }
                        }, 2000);
            }

            @Override
            public void onFootRefresh() {
                msr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msr.setLoadMore(false);
                    }
                }, 2000);


            }


        });
    }

}

