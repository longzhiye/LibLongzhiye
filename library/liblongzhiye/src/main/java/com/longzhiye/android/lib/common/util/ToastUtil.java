package com.longzhiye.android.lib.common.util;

import android.widget.Toast;

import com.longzhiye.android.lib.BaseApplication;

/**
 * 视图显示工具类
 * Author: longzhiye
 * Date: 2016-03-09
 * Time: 08:44
 */
public class ToastUtil {

    private static Toast mToast;

    /**
     * Toast显示
     *
     * @param displayString
     */
    public static void showToast(String displayString) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(),
                    displayString, Toast.LENGTH_LONG);
        } else {
            mToast.setText(displayString);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**
     * Toast显示
     *
     * @param resId
     */
    public static void showToast(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), resId,
                    Toast.LENGTH_LONG);
        } else {
            mToast.setText(resId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

}
