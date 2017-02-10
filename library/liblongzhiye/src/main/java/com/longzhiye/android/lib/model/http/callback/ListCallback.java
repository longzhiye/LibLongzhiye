package com.longzhiye.android.lib.model.http.callback;

import com.longzhiye.android.lib.common.util.JSONUtil;

import java.util.List;

/**
 * list回调
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:21
 */
public abstract class ListCallback<T> extends BaseCallback<T> {

    @Override
    public T parseNetworkResponse(String result) throws Exception {
        T t = JSONUtil.jsonToBeanList(result, mClass);
        return t;
    }

    @Override
    public void onResponse(T response) {

    }

    public abstract void onResponse(List<T> response);

}
