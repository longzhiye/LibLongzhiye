package com.longzhiye.android.demo.ui.activity.pulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.longzhiye.android.demo.R;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener;
import com.longzhiye.android.lib.ui.view.pulltorefreshview.MySwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉刷新,上拉加载更多RecyclerView
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 17:24
 */
public class PullReyclerViewActivity extends AppCompatActivity {

    private MySwipeRefreshLayout msr;
    private RecyclerView rv;

    private List<Map<String, String>> list = new ArrayList<>();

    private MyAdapter myAdapter;
    private int count = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_recyclerview);

        msr = (MySwipeRefreshLayout) findViewById(R.id.msr);
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter();
        rv.setAdapter(myAdapter);

        msr.setMyOnRefreshListener(new MyOnRefreshListener() {
            @Override
            public void onHeadRefresh() {
                msr.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                count = 300;
                                myAdapter.notifyDataSetChanged();
                                msr.setRefreshing(false);
                            }
                        }, 2000);
            }

            @Override
            public void onFootRefresh() {
                msr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        count = count + 300;
                        myAdapter.notifyDataSetChanged();
                        msr.setLoadMore(false);
                    }
                }, 2000);


            }


        });
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview, null));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return count;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }

    }


}

