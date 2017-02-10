package com.longzhiye.android.lib.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 动态设置GridView组建的高度
 * User: longzhiye
 * Date: 2016-05-28
 * Time: 10:37
 */
public class FullGridView extends GridView {
    public FullGridView(Context context) {
        super(context);
    }

    public FullGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 让ListView可以做ScrollView的子控件，但尺寸不会减小
     */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
