package com.longzhiye.android.lib.ui.activity.titlebar;

import android.view.View;
import android.widget.ImageView;

import com.longzhiye.android.lib.ui.activity.titlebar.view.TitleBar;


/**
 * 标题栏接口实现类
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:37
 */
public class TitleBarImpl implements TitleBarInterface {

    private TitleBar paramTitleBar;

    public TitleBarImpl(TitleBar paramTitleBar) {
        this.paramTitleBar = paramTitleBar;
    }

    public void setLeftButton(int paramInt,
                              View.OnClickListener paramOnClickListener) {
        if (paramInt == 0) {
            this.paramTitleBar.setLeftButtonVisible(false);
        } else {
            this.paramTitleBar.setLeftButtonVisible(true);
            this.paramTitleBar.setLeftButtonDrawable(paramInt);
            if (paramOnClickListener != null) {
                this.paramTitleBar.getLeftButton().setOnClickListener(
                        paramOnClickListener);
            }
        }
    }

    public void setTitleText(CharSequence paramCharSequence) {
        this.paramTitleBar.setTitleText(paramCharSequence);
    }

    public void setTitleText(int paramInt) {
        this.paramTitleBar.setTitleText(paramInt);
    }

    public void setRightButton(int paramInt,
                               View.OnClickListener paramOnClickListener) {
        if (paramInt == 0) {
            this.paramTitleBar.setRightButtonFirstVisible(false);
        } else {
            this.paramTitleBar.setRightButtonFirstVisible(true);
            this.paramTitleBar.setRightButtonFirstDrawable(paramInt);
            if (paramOnClickListener != null) {
                this.paramTitleBar.getRightButtonFirst().setOnClickListener(
                        paramOnClickListener);
            }
        }
    }

    public void setTitleBgResource(int paramInt) {
        this.paramTitleBar.setBackgroundResource(paramInt);
    }

    public void setTitleBgColorResource(int paramsInt) {
        this.paramTitleBar.setBackgroundColor(paramsInt);
    }

    public void setRightButtonSecond(int paramInt,
                                     View.OnClickListener paramOnClickListener) {
        if (paramInt == 0) {
            this.paramTitleBar.setRightButtonSecondVisible(false);
        } else {
            this.paramTitleBar.setRightButtonSecondVisible(true);
            this.paramTitleBar.setRightButtonSecondText(paramInt);
            if (paramOnClickListener != null) {
                this.paramTitleBar.getRightButtonSecond().setOnClickListener(
                        paramOnClickListener);
            }
        }
    }

    @Override
    public void setRightButtonSecond(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener) {
        this.paramTitleBar.setRightButtonSecondVisible(true);
        this.paramTitleBar.setRightButtonSecondText(paramCharSequence);
        if (paramOnClickListener != null) {
            this.paramTitleBar.getRightButtonSecond().setOnClickListener(
                    paramOnClickListener);
        }
    }

    @Override
    public void setRightButtonThirdly(int paramInt, View.OnClickListener paramOnClickListener) {
        if (paramInt == 0) {
            this.paramTitleBar.setRightButtonThirdlyVisible(false);
        } else {
            this.paramTitleBar.setRightButtonThirdlyVisible(true);
            this.paramTitleBar.setRightButtonThirdlyDrawable(paramInt);
            if (paramOnClickListener != null) {
                this.paramTitleBar.getRightButtonThirdly().setOnClickListener(
                        paramOnClickListener);
            }
        }
    }

    public void setRightButtonSecondTextColor(int paramInt) {
        this.paramTitleBar.setRightButtonSecondTextColor(paramInt);
    }

    public void setTitleTextColorResource(int paramInt) {
        this.paramTitleBar.setTextColor(paramInt);
    }

    @Override
    public ImageView getRightButtonFirst() {
        return this.paramTitleBar.getRightButtonFirst();
    }

    @Override
    public ImageView getRightButtonThirdly() {
        return this.paramTitleBar.getRightButtonThirdly();
    }

    /**
     * 获得左边按钮
     */
    @Override
    public ImageView getLeftButton() {
        return this.paramTitleBar.getLeftButton();
    }

}
