package com.longzhiye.android.libdemo.ui.titlebar;

import android.view.View;

import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.libdemo.R;

/**
 * 标题栏父类
 *
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 16:41
 */
public class TitleBarActivity extends TitleBarBaseActivity {

    @Override
    public int setContentContainer() {
        return R.layout.activity_title_bar;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("标题栏父类");
        setLeftButton(com.longzhiye.android.lib.R.mipmap.ic_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setRightButton(com.longzhiye.android.lib.R.mipmap.ic_pulltorefresh_arrow, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setRightButtonSecond(R.string.app_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setRightButtonThirdly(com.longzhiye.android.lib.R.mipmap.ic_pulltorefresh_arrow_up, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        return true;
    }
}
