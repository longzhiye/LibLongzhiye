package com.longzhiye.android.lib.model.http.callback;

/**
 * Object回调
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:21
 */
public abstract class StringCallback<String> extends BaseCallback<String> {

    public String parseNetworkResponse(String result) throws Exception {
        return result;
    }

}
