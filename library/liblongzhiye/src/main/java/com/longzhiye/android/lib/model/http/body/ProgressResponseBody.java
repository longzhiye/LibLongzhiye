package com.longzhiye.android.lib.model.http.body;

import android.os.Handler;

import com.longzhiye.android.lib.model.http.callback.FileDownloadHttpCallback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * 响应体封装，用于下载文件
 * Author: longzhiye
 * Date: 16-3-17
 * Time: 15:14
 */
public class ProgressResponseBody extends ResponseBody {

    //实际的待包装响应体
    private final ResponseBody responseBody;
    //进度回调接口
    private final FileDownloadHttpCallback progressListener;
    //包装完成的BufferedSource
    private BufferedSource bufferedSource;
    private Handler delivery;

    /**
     * 构造函数，赋值
     *
     * @param responseBody     待包装的响应体
     * @param progressListener 回调接口
     */
    public ProgressResponseBody(ResponseBody responseBody, FileDownloadHttpCallback progressListener, Handler delivery) {
        this.responseBody = responseBody;
        this.progressListener = progressListener;
        this.delivery = delivery;
    }

    /**
     * 重写调用实际的响应体的contentType
     *
     * @return MediaType
     */
    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    /**
     * 重写调用实际的响应体的contentLength
     *
     * @return contentLength
     * @throws IOException 异常
     */
    @Override
    public long contentLength() throws IOException {
        return responseBody.contentLength();
    }

    /**
     * 重写进行包装source
     *
     * @return BufferedSource
     * @throws IOException 异常
     */
    @Override
    public BufferedSource source() throws IOException {
        if (bufferedSource == null) {
            //包装
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }

    /**
     * 读取，回调进度接口
     *
     * @param source Source
     * @return Source
     */
    private Source source(Source source) {

        return new ForwardingSource(source) {
            //当前读取字节数
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                final long bytesRead = super.read(sink, byteCount);
                //增加当前读取的字节数，如果读取完成了bytesRead会返回-1
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                //回调，如果contentLength()不知道长度，会返回-1
                if (progressListener != null) {
                    delivery.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                progressListener.onProgress(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

                return bytesRead;
            }
        };
    }
}
