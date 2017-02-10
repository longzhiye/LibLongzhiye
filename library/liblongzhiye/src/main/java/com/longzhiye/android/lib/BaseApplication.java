package com.longzhiye.android.lib;

import android.app.Application;

/**
 * 自定义Application
 * Author: longzhiye
 * Date: 16-5-25
 * Time: 15:13
 */
public abstract class BaseApplication extends Application{

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
