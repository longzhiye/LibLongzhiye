package com.longzhiye.android.lib.ui.base;

import android.content.Context;

import com.longzhiye.android.lib.BaseApplication;

/**
 * Author: longzhiye
 * Date: 17/3/7
 * Time: 下午2:58
 * Email: longzhiye163@163.com
 */
public class BasePresenterImpl<T extends BaseMvpView> implements BasePresenter<T> {

    private T mMvpView;

    private Context context;

    private BaseApplication application;

    public BasePresenterImpl(Context context) {
        this.context = context;
    }

    public BasePresenterImpl() {

    }

    @Override
    public void attachView(T mvpView, Context context) {
        this.mMvpView = mvpView;
        this.context = context;
        application = (BaseApplication) context.getApplicationContext();
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    /**
     * 是否绑定视图
     *
     * @return
     */
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    /**
     * 检查视图绑定
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    /**
     * 自定义视图空异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call BasePresenter.attachView(BaseMvpView) before" +
                    " requesting data to the BasePresenter");
        }
    }

    /**
     * 获取视图
     *
     * @return
     */
    public T getMvpView() {
        return mMvpView;
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public Context getContext() {
        return context;
    }

    /**
     * 获取Application
     *
     * @return
     */
    public BaseApplication getApplication() {
        return application;
    }

}