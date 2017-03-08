package com.longzhiye.android.lib.ui.activity.titlebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.longzhiye.android.lib.R;
import com.longzhiye.android.lib.ui.activity.BaseActivity;
import com.longzhiye.android.lib.ui.activity.titlebar.view.TitleBar;


/**
 * 标题栏父类
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:17
 */
public abstract class TitleBarBaseActivity extends BaseActivity implements TitleBarInterface {

    // 标题栏
    private TitleBar titleBar;
    // 内容
    private LinearLayout llContentContainer;

    // 标题栏接口
    private TitleBarInterface titleInteface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater localLayoutInflater = LayoutInflater.from(this);
        initView();
        setLeftButton(R.mipmap.ic_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (setContentContainerBg() != -1) {
            this.llContentContainer
                    .setBackgroundResource(setContentContainerBg());
        }
        View localView = localLayoutInflater.inflate(setContentContainer(),
                null);
        this.llContentContainer.addView(localView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 初始化视图
     */
    private void initView() {
        setContentView(R.layout.activity_titlebar_base);
        titleBar = (TitleBar) findViewById(R.id.title_bar_layout);
        llContentContainer = (LinearLayout) findViewById(R.id.content_container);
        this.titleInteface = new TitleBarImpl(titleBar);
        // 判断是否显示标题栏
        if (!initTitleBar()) {
            this.titleBar.hide();
        }
    }

    /**
     * 设置显示内容布局文件
     *
     * @return
     */
    public abstract int setContentContainer();

    /**
     * 设置右边第二按钮的文本颜色
     */
    @Override
    public void setRightButtonSecondTextColor(int paramInt) {
        this.titleInteface.setRightButtonSecondTextColor(paramInt);
    }

    /**
     * 设置左边按钮
     */
    @Override
    public void setLeftButton(int paramInt,
                              View.OnClickListener paramOnClickListener) {
        this.titleInteface.setLeftButton(paramInt, paramOnClickListener);
    }

    /**
     * 获得左边按钮
     */
    @Override
    public ImageView getLeftButton() {
        return titleInteface.getLeftButton();
    }

    /**
     * 设置标题文字
     *
     * @param paramCharSequence
     */
    @Override
    public void setTitleText(CharSequence paramCharSequence) {
        this.titleInteface.setTitleText(paramCharSequence);
    }

    /**
     * 设置标题文字
     *
     * @param paramInt 资源文件
     */
    @Override
    public void setTitleText(int paramInt) {
        this.titleInteface.setTitleText(paramInt);
    }

    /**
     * 设置右边按钮
     */
    @Override
    public void setRightButton(int paramInt,
                               View.OnClickListener paramOnClickListener) {
        this.titleInteface.setRightButton(paramInt, paramOnClickListener);
    }

    /**
     * 获得右边按钮
     */
    @Override
    public ImageView getRightButtonFirst() {
        return titleInteface.getRightButtonFirst();
    }


    /**
     * 设置右边按钮
     */
    @Override
    public void setRightButtonThirdly(int paramInt,
                                      View.OnClickListener paramOnClickListener) {
        this.titleInteface.setRightButtonThirdly(paramInt, paramOnClickListener);
    }

    /**
     * 获得右边第三按钮
     */
    @Override
    public ImageView getRightButtonThirdly() {
        return titleInteface.getRightButtonThirdly();
    }

    /**
     * 初始化标题栏
     *
     * @return
     */
    public abstract boolean initTitleBar();

    /**
     * 设置标题背景
     */
    public void setTitleBgResource(int paramInt) {
        this.titleInteface.setTitleBgResource(paramInt);
    }

    /**
     * 设置标题栏背景
     *
     * @param paramsInt
     */
    public void setTitleBgColorResource(int paramsInt) {
        this.titleInteface.setTitleBgColorResource(paramsInt);
        findViewById(R.id.rl_parent).setBackgroundColor(getResources().getColor(paramsInt));
    }

    /**
     * 设置右边第二个按钮
     */
    public void setRightButtonSecond(int paramInt,
                                     View.OnClickListener paramOnClickListener) {
        this.titleInteface.setRightButtonSecond(paramInt, paramOnClickListener);
    }

    /**
     * 设置右边第二个按钮
     */
    public void setRightButtonSecond(CharSequence paramCharSequence,
                                     View.OnClickListener paramOnClickListener) {
        this.titleInteface.setRightButtonSecond(paramCharSequence, paramOnClickListener);
    }

    /**
     * 设置内容背景
     *
     * @return
     */
    public int setContentContainerBg() {
        return -1;
    }

    public void setTitleTextColorResource(int paramInt) {
        this.titleInteface.setTitleTextColorResource(paramInt);
    }

    public void setRightButtonFirstVisible(boolean paramBoolean) {
        titleBar.setRightButtonFirstVisible(paramBoolean);
    }

    public void setRightButtonSecondVisible(boolean paramBoolean) {
        titleBar.setRightButtonSecondVisible(paramBoolean);
    }

}
