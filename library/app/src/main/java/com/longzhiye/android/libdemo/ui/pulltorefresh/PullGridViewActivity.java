package com.longzhiye.android.libdemo.ui.pulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MySwipeRefreshLayout;
import com.longzhiye.android.libdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉刷新,上拉加载更多GridView
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 17:24
 */
public class PullGridViewActivity extends TitleBarBaseActivity {

    private MySwipeRefreshLayout msr;
    private GridView gv;

    private List<Map<String, String>> list = new ArrayList<>();

    private SimpleAdapter simpleAdapter;

    @Override
    public int setContentContainer() {
        return R.layout.activity_pull_gridview;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("GridView");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        msr = (MySwipeRefreshLayout) findViewById(R.id.msr);
        gv = (GridView) findViewById(R.id.gv);

        for (int i = 0; i < 300; i++) {
            list.add(new HashMap<String, String>());
        }
        simpleAdapter = new SimpleAdapter(PullGridViewActivity.this, list, R.layout.item_listview, new String[]{}, new int[]{});
        gv.setAdapter(simpleAdapter);

        msr.setMyOnRefreshListener(new MyOnRefreshListener() {
            @Override
            public void onHeadRefresh() {
                msr.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                list.clear();
                                for (int i = 0; i < 300; i++) {
                                    list.add(new HashMap<String, String>());
                                }
                                simpleAdapter.notifyDataSetChanged();
                                msr.setRefreshing(false);
                            }
                        }, 2000);
            }

            @Override
            public void onFootRefresh() {
                msr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 300; i++) {
                            list.add(new HashMap<String, String>());
                        }
                        simpleAdapter.notifyDataSetChanged();
                        msr.setLoadMore(false);
                    }
                }, 2000);


            }


        });
    }

}

