package com.longzhiye.android.lib.config;

import android.os.Environment;

/**
 * app配置文件
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 15:59
 */
public class AppConfig {

    /**
     * 网络连接超时
     */
    public static final int NET_TIME_OUT = 10;

    /**
     * 是否测试模式
     */
    public static final boolean IS_DEBUG = true;

    /**
     * 项目路径
     */
    public static final String PROJECT_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath()
            + java.io.File.separator
            + "Longzhiye" + java.io.File.separator;
    /**
     * 项目图片路径
     */
    public static final String PROJECT_IMAGE_PATH = PROJECT_PATH + "Image"
            + java.io.File.separator;
    /**
     * 项目下载路径
     */
    public static final String PROJECT_DOWNLOAD_PATH = PROJECT_PATH + "Download"
            + java.io.File.separator;
    /**
     * 项目临时路径
     */
    public static final String PROJECT_TEMP_PATH = PROJECT_PATH + "Temp"
            + java.io.File.separator;

    /**
     * 服务器返回成功码
     */
    public static final int RESPONSE_SUCCESS_CODE = 0;
    /**
     * 服务器返回失败码
     */
    public static final int RESPONSE_FAIL_CODE = 1;
    /**
     * 服务器返回成功参数名
     */
    public static final String RESPONSE_CODE_NAME = "code";
    /**
     * 服务器返回消息参数名
     */
    public static final String RESPONSE_MSG_NAME = "message";
    /**
     * 服务器返回数据参数名
     */
    public static final String RESPONSE_DATA_NAME = "data";

    /**
     * 当前页名称
     */
    public static final String PAGE_NAME = "page";
    /**
     * 页面大小名称
     */
    public static final String PAGE_SIZE_NAME = "page_size";
    /**
     * 页面大小
     */
    public static final Integer PAGE_SIZE = 10;

    /**
     * 重新登录
     */
    public static final int RESPONSE_ERROR_RE_LOGIN = 2;
    /**
     * 连接超时
     */
    public static final int RESPONSE_ERROR_TIME_OUT = 100;
    /**
     * 下载文件错误
     */
    public static final int RESPONSE_ERROR_DOWN_FILE_ERROR = 101;
    /**
     * 网络错误
     */
    public static final int RESPONSE_ERROR_NOT_FOUND = 404;
    /**
     * 网络错误
     */
    public static final int RESPONSE_ERROR_NET_ERROR = 500;


}
