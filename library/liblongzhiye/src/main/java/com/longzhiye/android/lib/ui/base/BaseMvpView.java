package com.longzhiye.android.lib.ui.base;

/**
 * Author: longzhiye
 * Date: 17/3/7
 * Time: 下午2:56
 * Email: longzhiye163@163.com
 */
public interface BaseMvpView {

    /**
     * 显示对话等待框
     */
    void showProgressDialog();

    /**
     * 关闭对话等待框
     */
    void dissmissProgress();

}
