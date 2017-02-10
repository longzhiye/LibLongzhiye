package com.longzhiye.android.lib.ui.activity.titlebar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longzhiye.android.lib.R;

/**
 * 默认视图（未登录）
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:51
 */
public class DefaultView extends LinearLayout {

    // 默认登录文本
    private TextView tvDefaultViewTextLogin;

    public DefaultView(Context paramContext) {
        super(paramContext);
        init();
    }

    public DefaultView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        View localView = LayoutInflater.from(getContext()).inflate(
                R.layout.view_not_login, null);
        tvDefaultViewTextLogin = (TextView) localView
                .findViewById(R.id.default_view_text_content);
        this.tvDefaultViewTextLogin.getPaint().setUnderlineText(true);
        addView(localView);
    }

    /**
     * 设置文本链接监听事件
     *
     * @param paramOnClickListener
     */
    public void setLinkClickListener(OnClickListener paramOnClickListener) {
        this.tvDefaultViewTextLogin.setOnClickListener(paramOnClickListener);
    }

}