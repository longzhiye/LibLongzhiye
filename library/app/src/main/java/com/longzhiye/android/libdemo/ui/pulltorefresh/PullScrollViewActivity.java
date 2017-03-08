package com.longzhiye.android.libdemo.ui.pulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MySwipeRefreshLayout;
import com.longzhiye.android.libdemo.R;

/**
 * 下拉刷新,上拉加载更多ScrollView
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 17:24
 */
public class PullScrollViewActivity extends TitleBarBaseActivity {

    private MySwipeRefreshLayout msr;
    private ScrollView sv;

    @Override
    public int setContentContainer() {
        return R.layout.activity_pull_scrollview;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("ScrollView");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

