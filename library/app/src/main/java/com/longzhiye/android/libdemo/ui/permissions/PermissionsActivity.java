package com.longzhiye.android.libdemo.ui.permissions;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.longzhiye.android.lib.common.util.ToastUtil;
import com.longzhiye.android.lib.ui.activity.titlebar.TitleBarBaseActivity;
import com.longzhiye.android.libdemo.R;


/**
 * 权限封装
 * Author: longzhiye
 * Date: 17/3/8
 * Time: 上午10:44
 * Email: longzhiye163@163.com
 */
public class PermissionsActivity extends TitleBarBaseActivity implements View.OnClickListener {

    /**
     * 请求权限返回码
     */
    private static final int REQUEST_CODE_PERMISSION = 1;

    private Button btn1;

    @Override
    public int setContentContainer() {
        return R.layout.activity_permissions;
    }

    @Override
    public boolean initTitleBar() {
        setTitleText("权限封装");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
    }

    private void initListener() {
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                checkPermission();
                break;
        }
    }

    /**
     * 检查权限
     */
    private void checkPermission() {
        // 需要的全部权限
        String[] allPermission = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
        };
        performCodeWithPermission("禁用权限可能导致应用无法运行", REQUEST_CODE_PERMISSION, allPermission, new PermissionCallback() {

            @Override
            public void hasPermission() {
                ToastUtil.showToast("权限获取成功");
            }

            @Override
            public void noPermission(Boolean hasPermanentlyDenied) {
                if (hasPermanentlyDenied) {
                    //只是提供跳转系统设置的提示 系统返回后不做检查处理
//                  alertAppSetPermission(getString(R.string.permission_storage_deny_again));

                    //如果需要跳转系统设置页后返回自动再次检查和执行业务
                    alertAppSetPermission("打开应用程序设置修改应用程序", REQUEST_CODE_PERMISSION);
                }
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_PERMISSION:
                    //如果需要跳转系统设置页后返回自动再次检查和执行业务 如果不需要则不需要重写onActivityResult
                    checkPermission();
                    break;
            }
        }
    }

}
