package com.longzhiye.android.lib.common.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Author: longzhiye
 * Date: 16-12-9
 * Time: 13:40
 */
public class KeyboardUtil {

    public static void showSoftInput(Context context, View view) {
        // 收起软键盘
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
    }

    public static void closeSoftInput(Context context, View view) {
        // 收起软键盘
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
