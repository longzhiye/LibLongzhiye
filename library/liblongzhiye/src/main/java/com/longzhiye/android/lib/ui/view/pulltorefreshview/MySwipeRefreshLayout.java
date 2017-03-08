package com.longzhiye.android.lib.ui.view.pulltorefreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.longzhiye.android.lib.R;

/**
 * 下拉刷新底部加载
 * Author: longzhiye
 * Date: 16-3-11
 * Time: 17:04
 */
public class MySwipeRefreshLayout extends SuperSwipeRefreshLayout {

    // Header View
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;

    // Footer View
    private ProgressBar footerProgressBar;
    private TextView footerTextView;
    private ImageView footerImageView;

    private com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener myOnRefreshListener;

    public MySwipeRefreshLayout(Context context) {
        super(context);

    }

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setHeaderView(createHeaderView());// add headerView
        setFooterView(createFooterView());
        setTargetScrollWithLayout(true);
        setOnPullRefreshListener(new MyOnRefreshListener());
        setOnPushLoadMoreListener(new MyOnRefreshListener());
    }

    private View createFooterView() {
        View footerView = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_footer, null);
        footerProgressBar = (ProgressBar) footerView
                .findViewById(R.id.footer_pb_view);
        footerImageView = (ImageView) footerView
                .findViewById(R.id.footer_image_view);
        footerTextView = (TextView) footerView
                .findViewById(R.id.footer_text_view);
        footerProgressBar.setVisibility(View.GONE);
        footerImageView.setVisibility(View.VISIBLE);
        footerImageView.setImageResource(R.mipmap.ic_pulltorefresh_arrow);
        footerTextView.setText("上拉加载更多...");
        return footerView;
    }

    private View createHeaderView() {
        View headerView = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_head, null);
        progressBar = (ProgressBar) headerView.findViewById(R.id.pb_view);
        textView = (TextView) headerView.findViewById(R.id.text_view);
        textView.setText("下拉刷新");
        imageView = (ImageView) headerView.findViewById(R.id.image_view);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.mipmap.ic_pulltorefresh_arrow);
        progressBar.setVisibility(View.GONE);
        return headerView;
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        super.setRefreshing(refreshing);
        if (!refreshing) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setLoadMore(boolean loadMore) {
        super.setLoadMore(loadMore);
        if (!loadMore) {
            footerImageView.setVisibility(View.VISIBLE);
            footerProgressBar.setVisibility(View.GONE);
        }
    }

    public void setMyOnRefreshListener(com.longzhiye.android.lib.ui.view.pulltorefreshview.MyOnRefreshListener myOnRefreshListener) {
        this.myOnRefreshListener = myOnRefreshListener;
    }

    public class MyOnRefreshListener implements SuperSwipeRefreshLayout.OnPullRefreshListener, SuperSwipeRefreshLayout.OnPushLoadMoreListener {

        @Override
        public void onRefresh() {
            textView.setText("正在刷新");
            imageView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            if (myOnRefreshListener != null) {
                myOnRefreshListener.onHeadRefresh();
            }
        }

        @Override
        public void onPullDistance(int distance) {
            // pull distance
        }

        @Override
        public void onPullEnable(boolean enable) {
            textView.setText(enable ? "松开刷新" : "下拉刷新");
            imageView.setVisibility(View.VISIBLE);
            imageView.setRotation(enable ? 180 : 0);
        }

        @Override
        public void onLoadMore() {
            footerTextView.setText("正在加载...");
            footerImageView.setVisibility(View.GONE);
            footerProgressBar.setVisibility(View.VISIBLE);
            if (myOnRefreshListener != null) {
                myOnRefreshListener.onFootRefresh();
            }
        }

        @Override
        public void onPushEnable(boolean enable) {
            footerTextView.setText(enable ? "松开加载" : "上拉加载");
            footerImageView.setVisibility(View.VISIBLE);
            footerImageView.setRotation(enable ? 0 : 180);
        }

        @Override
        public void onPushDistance(int distance) {
        }

    }

}