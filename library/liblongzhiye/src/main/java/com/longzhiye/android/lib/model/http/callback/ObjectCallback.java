package com.longzhiye.android.lib.model.http.callback;

import com.longzhiye.android.lib.common.util.JSONUtil;

/**
 * Object回调
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:21
 */
public abstract class ObjectCallback<T> extends BaseCallback<T> {


//    private T t;
//
    @Override
    public T parseNetworkResponse(String result) throws Exception {
        T t = JSONUtil.jsonToBean(result, mClass);
        return t;
    }

}
