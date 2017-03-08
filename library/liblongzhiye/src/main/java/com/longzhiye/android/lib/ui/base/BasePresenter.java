package com.longzhiye.android.lib.ui.base;

import android.content.Context;

/**
 *
 * Author: longzhiye
 * Date: 17/3/7
 * Time: 下午2:57
 * Email: longzhiye163@163.com
 */
public interface BasePresenter<V extends BaseMvpView> {

    /**
     * 绑定视图
     * @param mvpView
     * @param context
     */
    void attachView(V mvpView, Context context);

    /**
     * 解绑视图
     */
    void detachView();

}

