package com.longzhiye.android.demo.ui.activity.selectimg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.longzhiye.android.demo.R;
import com.longzhiye.android.lib.common.util.LogUtil;
import com.longzhiye.android.lib.config.AppConfig;
import com.longzhiye.android.lib.ui.view.selectimg.GlideLoader;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.ArrayList;

/**
 * 图片选择
 *
 * Author: longzhiye
 * Date: 16-5-28
 * Time: 10:56
 */
public class SelectImgActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;

    private ArrayList<String> selectImgs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_img);

        findViewById(R.id.btn_single).setOnClickListener(this);
        findViewById(R.id.btn_multiple).setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_single:
                ImageConfig imageConfig
                        = new ImageConfig.Builder(new GlideLoader())
                        // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                        .steepToolBarColor(getResources().getColor(R.color.default_theme))
                        // 标题的背景颜色 （默认黑色）
                        .titleBgColor(getResources().getColor(R.color.default_theme))
                        // 提交按钮字体的颜色  （默认白色）
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        // 标题颜色 （默认白色）
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                        .filePath(AppConfig.PROJECT_IMAGE_PATH)
                        // 开启单选   （默认为多选）
                        .singleSelect()
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        .build();
                ImageSelector.open(SelectImgActivity.this, imageConfig);   // 开启图片选择器
                break;
            case R.id.btn_multiple:
                ImageConfig imageConfig2
                        = new ImageConfig.Builder(new GlideLoader())
                        .steepToolBarColor(getResources().getColor(R.color.blue))
                        .titleBgColor(getResources().getColor(R.color.blue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启多选   （默认为多选）
                        .mutiSelect()
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        // 已选择的图片路径
                        .pathList(selectImgs)
                        // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                        .filePath(AppConfig.PROJECT_IMAGE_PATH)
                        .build();
                ImageSelector.open(SelectImgActivity.this, imageConfig2);   // 开启图片选择器
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageSelector.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            // Get Image Path List
            ArrayList<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);

            selectImgs = pathList;

            StringBuffer sb = new StringBuffer();
            for (String path : pathList) {
                sb.append(path).append("\n");
                LogUtil.i("ImagePathList", path);
            }
            tvResult.setText(sb.toString());
        }
    }
}
