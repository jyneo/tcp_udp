package com.jyneo.tcp_udp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jyneo.tcp_udp.R;
import com.jyneo.tcp_udp.custom.MyTitleBar;

public class MainMenuActivity extends AppCompatActivity {

    private MyTitleBar tbTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(); // 初始化标题栏

        setStatusBarColor(this, "#7067E2");
    }

    private void initView() {
        // 初始化控件
        tbTitle = findViewById(R.id.custom_title_bar);
        // 设置背景色
        tbTitle.setBackColor("#7067E2");

        // 设置左侧文字显示文字，也可设置背景图
        tbTitle.setLeftText("Read Me");
        // 设置左侧控件点击事件
        tbTitle.setOnClickListenerLeft(new MyTitleBar.OnClickListenerLeft() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ReadMeActivity.class);
                startActivity(intent);
            }
        });
        // 设置中间的标题
        tbTitle.setTitleText("Main Menu");
        tbTitle.setTitleTextSize(20);

        // 设置左侧文字显示文字，也可设置背景图
        tbTitle.setRightText("About Me");
        tbTitle.setRightVisible(true);
        // 设置左侧控件点击事件
        tbTitle.setOnClickListenerRight(new MyTitleBar.OnClickListenerRight() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setStatusBarColor(Activity activity, String statusColor) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarUpperAPI21(activity, statusColor);
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setStatusBarUpperAPI19(activity, statusColor);
        }
    }

    public void setStatusBarUpperAPI21(Activity activity, String statusColor) {
        Window window = activity.getWindow();
        // 取消状态栏透明, 使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 设置状态栏颜色
        window.setStatusBarColor(Color.parseColor(statusColor));
        // 设置系统状态栏处于可见状态
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        // 让view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = window.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            // 注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View , 预留出系统 View 的空间
            ViewCompat.setFitsSystemWindows(mChildView, false);
            ViewCompat.requestApplyInsets(mChildView);
        }

    }

    public void setStatusBarUpperAPI19(Activity activity, String statusColor) {

    }
}
