package com.jyneo.tcp_udp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jyneo.tcp_udp.R;
import com.jyneo.tcp_udp.custom.MyTitleBar;

/**
 *
 * Created by yj2595 on 2018/4/9.
 */

public class AboutMeActivity extends BaseActivity{

    private static final String TAG = "AboutMeActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_about_me);

        initView();
    }

    private void initView() {
        // 初始化控件
        MyTitleBar myTitleBar = findViewById(R.id.custom_title_bar);
        // 设置背景色
        myTitleBar.setBackColor("#7067E2");

        // 设置左侧文字显示文字
        myTitleBar.setLeftText("Main Menu");
        // 设置左侧控件点击事件
        myTitleBar.setOnClickListenerLeft(new MyTitleBar.OnClickListenerLeft() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutMeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 设置中间的标题
        myTitleBar.setTitleText("About Me");
        myTitleBar.setTitleTextSize(20);

    }
}
