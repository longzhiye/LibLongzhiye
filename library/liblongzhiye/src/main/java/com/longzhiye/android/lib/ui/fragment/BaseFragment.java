package com.longzhiye.android.lib.ui.fragment;

import android.support.v4.app.Fragment;

import com.longzhiye.android.lib.R;
import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.ui.activity.BaseActivity;

/**
 * 所有Fragment父类
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 12:02
 */
public abstract class BaseFragment extends Fragment {

    private final String TAG = BaseFragment.class.getSimpleName();

    /**
     * 显示等待对话框
     */
    public void showProgressDialog() {
        showProgressDialog("正在拼命加载中,请稍候");
    }

    /**
     * 显示等待对话框
     *
     * @param content
     */
    public void showProgressDialog(String content) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog(content);
        } else {
            LogUtil.e(TAG, getString(R.string.type_cannot_be_converted));
        }
    }

    /**
     * 关闭等待对话框
     */
    public void dissmissProgress() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).dissmissProgress();
        } else {
            LogUtil.e(TAG, getString(R.string.type_cannot_be_converted));
        }
    }

}
