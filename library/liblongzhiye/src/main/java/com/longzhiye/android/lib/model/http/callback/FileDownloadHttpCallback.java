package com.longzhiye.android.lib.model.http.callback;

import java.io.File;

/**
 * 文件下载回调
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:21
 */
public abstract class FileDownloadHttpCallback extends BaseCallback<File> {

    @Override
    public File parseNetworkResponse(String result) throws Exception {
        return null;
    }

    /**
     * 下载进度回调
     *
     * @param byteCount     当前下载大小
     * @param contentLength 文件大小
     * @param done          下载完成
     */
    public abstract void onProgress(long byteCount, long contentLength, boolean done);
}
