package com.longzhiye.android.lib.common.util;

import android.util.Log;

import com.longzhiye.android.lib.config.AppConfig;

/**
 * 自定义日志
 * Author: longzhiye
 * Date: 16-01-01
 * Time: 10:55
 */
public class LogUtil {

    /**
     * Log.v 的调试颜色为黑色的，任何消息都会输出，这里的v代表verbose啰嗦的意思，平时使用就是Log.v("","");
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (AppConfig.IS_DEBUG) {
            if (tag != null && msg != null) {
                Log.v(tag, msg);
            }
        }
    }

    /**
     * Log.d的输出颜色是蓝色的，仅输出debug调试的意思，但他会输出上层的信息，过滤起来可以通过DDMS的Logcat标签来选择.
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (AppConfig.IS_DEBUG) {
            if (tag != null && msg != null) {
                Log.d(tag, msg);
            }
        }
    }

    /**
     * Log.i的输出为绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (AppConfig.IS_DEBUG) {
            if (tag != null && msg != null) {
                Log.i(tag, msg);
            }
        }
    }

    /**
     * Log.w的意思为橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息。
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        if (AppConfig.IS_DEBUG) {
            if (tag != null && msg != null) {
                Log.w(tag, msg);
            }
        }
    }

    /**
     * Log.e为红色，可以想到error错误，这里仅显示红色的错误信息，这些错误就需要我们认真的分析，查看栈的信息了。
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (AppConfig.IS_DEBUG) {
            if (tag != null && msg != null) {
                Log.e(tag, msg);
            }
        }
    }


}
