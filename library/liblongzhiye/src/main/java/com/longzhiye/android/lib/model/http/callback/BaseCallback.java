package com.longzhiye.android.lib.model.http.callback;

import android.content.Context;

/**
 * 网络请求回调父类
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:17
 */
public abstract class BaseCallback<T> {

    // 转换类型数据
    protected Class<T> mClass;

    /**
     * 开始网络请求
     */
    public void onStart() {
    }

    /**
     * 结束网络请求
     */
    public void onEnd() {
    }

    /**
     * 转换数据
     *
     * @param result
     * @return
     * @throws Exception
     */
    public abstract T parseNetworkResponse(String result) throws Exception;

    /**
     * 返回数据响应
     *
     * @param response 返回响应数据
     */
    public abstract void onResponse(T response);

    /**
     * 返回错误
     *
     * @param context   上下文
     * @param errorCode 错误码
     * @param errorTip  错误提示
     */
    public abstract void onError(Context context, int errorCode, String errorTip);

    /**
     * 设置转换类型数据
     *
     * @param mClass
     */
    public void setmClass(Class<T> mClass) {
        this.mClass = mClass;
    }
}