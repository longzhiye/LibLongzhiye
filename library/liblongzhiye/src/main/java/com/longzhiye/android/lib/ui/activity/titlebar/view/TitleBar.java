package com.longzhiye.android.lib.ui.activity.titlebar.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longzhiye.android.lib.R;


/**
 * 标题栏视图
 *
 * @author Administrator
 */
public class TitleBar extends LinearLayout {

    // 左边按钮
    private ImageView ivBtnLeft;
    // 右边提交按钮
    private Button btnSubtitleLeft;
    // 右边第一提交按钮
    private ImageView btnRightFirst;
    // 右边第二个按钮
    private TextView tvBtnRightSecond;
    // 右边第三提交按钮
    private ImageView btnRightThirdly;
    // 标题页面
//    private TitleBarPageView tbpPage;
    // 标题文本
    private TextView tvTitle;
    // 标题栏
    private View viewTitleBar;

    public TitleBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.viewTitleBar = ((LayoutInflater) paramContext
                .getSystemService("layout_inflater")).inflate(
                R.layout.view_titlebar, null);
        setOrientation(VERTICAL);
        LayoutParams localLayoutParams = new LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        addView(this.viewTitleBar, localLayoutParams);
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        ivBtnLeft = (ImageView) viewTitleBar
                .findViewById(R.id.titlebar_btn_left);
        btnSubtitleLeft = (Button) viewTitleBar
                .findViewById(R.id.titlebar_subtitle_left);
        btnRightFirst = (ImageView) viewTitleBar
                .findViewById(R.id.titlebar_btn_right_first);
        tvBtnRightSecond = (TextView) viewTitleBar
                .findViewById(R.id.titlebar_btn_right_second);
        btnRightThirdly = (ImageView) viewTitleBar.findViewById(R.id.titlebar_btn_right_thirdly);
//        tbpPage = (TitleBarPageView) viewTitleBar
//                .findViewById(R.id.titlebar_page);
        tvTitle = (TextView) viewTitleBar
                .findViewById(R.id.titlebar_text_title);

//        new Shimmer().start(tvTitle);
    }

    /**
     * 隐藏标题
     */
    public void hide() {
        setVisibility(View.GONE);
    }

    /**
     * 获得左边按钮的图片视图
     *
     * @return
     */
    public ImageView getLeftButton() {
        return ivBtnLeft;
    }

    /**
     * 获得左边提交按钮
     *
     * @return
     */
    public Button getLeftSubTitleBtn() {
        return btnSubtitleLeft;
    }

    /**
     * 获得右边第一个按钮的图片视图
     *
     * @return
     */
    public ImageView getRightButtonFirst() {
        return btnRightFirst;
    }

    /**
     * 获得右边第二按钮文本
     *
     * @return
     */
    public TextView getRightButtonSecond() {
        return tvBtnRightSecond;
    }

    /**
     * 获得右边第三个按钮的图片视图
     *
     * @return
     */
    public ImageView getRightButtonThirdly() {
        return btnRightThirdly;
    }

//    /**
//     * 设置当前页面
//     *
//     * @param paramInt
//     */
//    public void setCurrentPage(int paramInt) {
//        tbpPage.setCurrentPage(paramInt);
//    }

    /**
     * 设置左边按钮点击事件监听
     *
     * @param paramOnClickListener
     */
    public void setLeftButtonClickListener(
            OnClickListener paramOnClickListener) {
        ivBtnLeft.setOnClickListener(paramOnClickListener);
    }

    /**
     * 设置左边按钮图片资源
     *
     * @param paramInt
     */
    public void setLeftButtonDrawable(int paramInt) {
        ivBtnLeft.setImageResource(paramInt);
    }

    /**
     * 设置是否显示左边按钮
     *
     * @param paramBoolean
     */
    public void setLeftButtonVisible(boolean paramBoolean) {
        ImageView localImageView = ivBtnLeft;
        if (paramBoolean) {
            localImageView.setVisibility(View.VISIBLE);
        } else {
            localImageView.setVisibility(View.GONE);
        }
    }

    /**
     * 设置左边提交按钮文字
     *
     * @param paramCharSequence
     */
    public void setLeftSubTitle(CharSequence paramCharSequence) {
        btnSubtitleLeft.setVisibility(View.VISIBLE);
        btnSubtitleLeft.setText(paramCharSequence);
    }

    /**
     * 设置左边提交按钮监听事件
     *
     * @param paramOnClickListener
     */
    public void setLeftSubtTitleListener(
            OnClickListener paramOnClickListener) {
        btnSubtitleLeft.setOnClickListener(paramOnClickListener);
    }

    /**
     * 设置是否显示左边提交按钮
     *
     * @param paramBoolean
     */
    public void setLeftSubtTitleVisible(boolean paramBoolean) {
        Button localButton = btnSubtitleLeft;
        if (paramBoolean) {
            localButton.setVisibility(View.VISIBLE);
        } else {
            localButton.setVisibility(View.GONE);
        }
    }

//    /**
//     * 设置页面显示数量
//     *
//     * @param paramInt
//     */
//    public void setPageTotalCount(int paramInt) {
//        setPageVisible(true);
//        tbpPage.setTotalPage(paramInt);
//    }
//
//    /**
//     * 设置是否显示页面
//     *
//     * @param paramBoolean
//     */
//    public void setPageVisible(boolean paramBoolean) {
//        TitleBarPageView localTitleBarPageView = tbpPage;
//        if (paramBoolean) {
//            localTitleBarPageView.setVisibility(View.VISIBLE);
//            tvTitle.setVisibility(View.GONE);
//        } else {
//            localTitleBarPageView.setVisibility(View.GONE);
//        }
//    }

    /**
     * 设置右边第一个按钮监听事件
     *
     * @param paramOnClickListener
     */
    public void setRightButtonFirstClickListener(
            OnClickListener paramOnClickListener) {
        btnRightFirst.setOnClickListener(paramOnClickListener);
    }

    /**
     * 设置右边第一个按钮背景
     *
     * @param paramInt
     */
    public void setRightButtonFirstDrawable(int paramInt) {
        btnRightFirst.setImageResource(paramInt);
    }

    /**
     * 设置是否显示右边按钮
     *
     * @param paramBoolean
     */
    public void setRightButtonFirstVisible(boolean paramBoolean) {
        ImageView localImageView = btnRightFirst;
        if (paramBoolean) {
            localImageView.setVisibility(View.VISIBLE);
        } else {
            localImageView.setVisibility(View.GONE);
        }
    }

    /**
     * 设置右边第二个按钮的点击监听事件
     *
     * @param paramOnClickListener
     */
    public void setRightButtonSecondClickListener(
            OnClickListener paramOnClickListener) {
        tvBtnRightSecond.setOnClickListener(paramOnClickListener);
    }

    /**
     * 设置右边第二个按钮的文本
     *
     * @param paramInt
     */
    public void setRightButtonSecondText(int paramInt) {
        tvBtnRightSecond.setText(paramInt);
    }

    /**
     * 设置右边第二个按钮的文本
     *
     * @param paramInt
     */
    public void setRightButtonSecondText(CharSequence paramCharSequence) {
        tvBtnRightSecond.setText(paramCharSequence);
    }

    /**
     * 设置右边第二个按钮的文本颜色
     *
     * @param paramInt
     */
    public void setRightButtonSecondTextColor(int paramInt) {
        tvBtnRightSecond.setTextColor(paramInt);
    }

    /**
     * 设置是否显示右边第二个按钮
     *
     * @param paramBoolean
     */
    public void setRightButtonSecondVisible(boolean paramBoolean) {
        TextView localTextView = tvBtnRightSecond;
        if (paramBoolean) {
            localTextView.setVisibility(View.VISIBLE);
        } else {
            localTextView.setVisibility(View.GONE);
        }
    }


    /**
     * 设置右边第三个按钮监听事件
     *
     * @param paramOnClickListener
     */
    public void setRightButtonThirdlyClickListener(
            OnClickListener paramOnClickListener) {
        btnRightThirdly.setOnClickListener(paramOnClickListener);
    }

    /**
     * 设置右边第三个按钮背景
     *
     * @param paramInt
     */
    public void setRightButtonThirdlyDrawable(int paramInt) {
        btnRightThirdly.setImageResource(paramInt);
    }

    /**
     * 设置是否显示右边第三个按钮
     *
     * @param paramBoolean
     */
    public void setRightButtonThirdlyVisible(boolean paramBoolean) {
        ImageView localImageView = btnRightThirdly;
        if (paramBoolean) {
            localImageView.setVisibility(View.VISIBLE);
        } else {
            localImageView.setVisibility(View.GONE);
        }
    }

    /**
     * 设置标题文本颜色
     *
     * @param paramInt
     */
    public void setTextColor(int paramInt) {
        tvTitle.setTextColor(paramInt);
    }

    // public void setTitleBarStyle(b paramb) {
    // paramb.a(this.viewTitleBar, ivBtnLeft, btnRightFirst, tvTitle);
    // }

    /**
     * 设置标题文本背景
     *
     * @param paramInt
     */
    public void setTitleDrawable(int paramInt) {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setBackgroundResource(paramInt);
    }

    /**
     * 设置标题文本
     *
     * @param paramInt
     */
    public void setTitleText(int paramInt) {
        tvTitle.setText(paramInt);
    }

    /**
     * 设置标题文本
     *
     * @param paramCharSequence
     */
    public void setTitleText(CharSequence paramCharSequence) {
        tvTitle.setText(paramCharSequence);
    }

}