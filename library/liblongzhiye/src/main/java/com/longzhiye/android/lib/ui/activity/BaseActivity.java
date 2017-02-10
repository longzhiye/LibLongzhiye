package com.longzhiye.android.lib.ui.activity;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.longzhiye.android.lib.model.http.HttpUtil;

/**
 * 所有Activity父类
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:07
 */
public abstract class BaseActivity extends FragmentActivity {

    // 等待对话框
    private Dialog progDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 禁止横屏显示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //沉浸式通知栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 添加透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HttpUtil.getInstance().cancelNet(this);
    }

    /**
     * 显示等待对话框
     */
    public void showProgressDialog() {
        showProgressDialog("正在拼命加载中,请稍候");
    }

    /**
     * 显示等待对话框
     *
     * @param content
     */
    public void showProgressDialog(String content) {
        if (progDialog == null) {
//            LayoutInflater inflater = LayoutInflater.from(this);
//            View v = inflater.inflate(R.layout.view_my_progress_dialog, null);// 得到加载view
//            progDialog = new Dialog(this, R.style.MyProgressDialog);// 创建自定义样式dialog
//
//            progDialog.setCancelable(true);// 不可以用“返回键”取消
//            progDialog.setCanceledOnTouchOutside(true);// 设置点击屏幕Dialog不消失
//            progDialog.setContentView(v, new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));// 设置布局
//            progDialog.show();
        } else if (!progDialog.isShowing()) {
            progDialog.show();
        }
    }

    /**
     * 关闭等待对话框
     */
    public void dissmissProgress() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
    }

}
