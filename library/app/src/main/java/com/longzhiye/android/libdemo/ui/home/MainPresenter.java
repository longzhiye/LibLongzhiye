package com.longzhiye.android.libdemo.ui.home;

import android.content.Intent;

import com.longzhiye.android.lib.ui.base.BasePresenterImpl;
import com.longzhiye.android.libdemo.ui.net.NetActivity;
import com.longzhiye.android.libdemo.ui.permissions.PermissionsActivity;
import com.longzhiye.android.libdemo.ui.pulltorefresh.PulltorefreshActivity;
import com.longzhiye.android.libdemo.ui.selectimg.SelectImgActivity;
import com.longzhiye.android.libdemo.ui.titlebar.TitleBarActivity;

/**
 * Author: longzhiye
 * Date: 17/3/7
 * Time: 下午3:12
 * Email: longzhiye163@163.com
 */
public class MainPresenter extends BasePresenterImpl<MainMvpView> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    public void switchNetView(){
        getContext().startActivity(new Intent(getContext(), NetActivity.class));
    }

    public void switchTitleBarView(){
        getContext().startActivity(new Intent(getContext(), TitleBarActivity.class));
    }

    public void switchPullToRefreshView(){
        getContext().startActivity(new Intent(getContext(), PulltorefreshActivity.class));
    }

    public void switchSelectImgView(){
        getContext().startActivity(new Intent(getContext(), SelectImgActivity.class));
    }

    public void switchPermissionsView(){
        getContext().startActivity(new Intent(getContext(), PermissionsActivity.class));
    }


}
