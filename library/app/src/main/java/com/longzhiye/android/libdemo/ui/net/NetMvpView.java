package com.longzhiye.android.libdemo.ui.net;

import com.longzhiye.android.lib.ui.base.BaseMvpView;
import com.longzhiye.android.libdemo.model.bean.BeanA;
import com.longzhiye.android.libdemo.model.bean.BeanB;
import com.longzhiye.android.libdemo.model.bean.BeanC;

import java.util.List;

/**
 * Author: longzhiye
 * Date: 17/3/8
 * Time: 上午8:55
 * Email: longzhiye163@163.com
 */
public interface NetMvpView extends BaseMvpView{

    /**
     * 显示对象
     * @param response
     */
    public void showObject(BeanC response);

    /**
     * 显示列表
     * @param response
     */
    public void showList(BeanA response);

    /**
     * 显示列表
     * @param response
     */
    public void showList2(List<BeanB> response);

    /**
     * 显示下载进度
     * @param byteCount
     * @param contentLength
     * @param done
     */
    public void showDownloadFile(long byteCount, long contentLength, boolean done);

}
