package com.jyneo.tcp_udp.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jyneo.tcp_udp.R;
import com.jyneo.tcp_udp.custom.MyButton;
import com.jyneo.tcp_udp.custom.MyTitleBar;

/**
 *
 * Created by yj2595 on 2018/4/9.
 */

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainMenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_main);

        initTitleBar(); // 初始化标题栏
        initButton(); // 初始化按钮
        setStatusBarColor(this);
    }

    private void initTitleBar() {
        // 初始化控件
        MyTitleBar myTitleBar = findViewById(R.id.custom_title_bar);
        // 设置背景色
        myTitleBar.setBackColor("#7067E2");

        // 设置左侧文字显示文字
        myTitleBar.setLeftText("Read Me");
        // 设置左侧控件点击事件
        myTitleBar.setOnClickListenerLeft(new MyTitleBar.OnClickListenerLeft() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReadMeActivity.class);
                startActivity(intent);
            }
        });

        // 设置中间的标题
        myTitleBar.setTitleText("Main Menu");
        myTitleBar.setTitleTextSize(20);

        // 设置右侧文字显示文字
        myTitleBar.setRightText("About Me");
        myTitleBar.setRightVisible(true); // 默认不可见
        // 设置右侧控件点击事件
        myTitleBar.setOnClickListenerRight(new MyTitleBar.OnClickListenerRight() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initButton() {
        MyButton button_tcp_client = findViewById(R.id.button_tcp_client);
        button_tcp_client.setBackColor("#4169E1");
        button_tcp_client.setBackColorSelected("#4169E1");
        button_tcp_client.setTextColorS("#FFFFFF");
        button_tcp_client.setBackColorSelected("#C0C0C0");
        button_tcp_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TcpClientActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_tcp_server = findViewById(R.id.button_tcp_server);
        button_tcp_server.setBackColor("#4169E1");
        button_tcp_server.setBackColorSelected("#4169E1");
        button_tcp_server.setTextColorS("#FFFFFF");
        button_tcp_server.setBackColorSelected("#C0C0C0");
        button_tcp_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TcpServerActivity.class);
                startActivity(intent);
            }
        });
        
        MyButton button_udp_client = findViewById(R.id.button_udp_client);
        button_udp_client.setBackColor("#4169E1");
        button_udp_client.setBackColorSelected("#4169E1");
        button_udp_client.setTextColorS("#FFFFFF");
        button_udp_client.setBackColorSelected("#C0C0C0");
        button_udp_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UdpClientActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_udp_server = findViewById(R.id.button_udp_server);
        button_udp_server.setBackColor("#4169E1");
        button_udp_server.setBackColorSelected("#4169E1");
        button_udp_server.setTextColorS("#FFFFFF");
        button_udp_server.setBackColorSelected("#C0C0C0");
        button_udp_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UdpServerActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_bluetooth_connect = findViewById(R.id.button_bluetooth);
        button_bluetooth_connect.setBackColor("#4169E1");
        button_bluetooth_connect.setBackColorSelected("#4169E1");
        button_bluetooth_connect.setTextColorS("#FFFFFF");
        button_bluetooth_connect.setBackColorSelected("#C0C0C0");
        button_bluetooth_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_smart_config = findViewById(R.id.button_smart_config);
        button_smart_config.setBackColor("#4169E1");
        button_smart_config.setBackColorSelected("#4169E1");
        button_smart_config.setTextColorS("#FFFFFF");
        button_smart_config.setBackColorSelected("#C0C0C0");
        button_smart_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmartConfigActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setStatusBarColor(Activity activity) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0以上
            setStatusBarUpperAPI21(activity);
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // 4.4 - 5.0
            setStatusBarUpperAPI19(activity);
        }
    }

    public void setStatusBarUpperAPI21(Activity activity) {
        Window window = activity.getWindow();
        // 取消状态栏透明, 使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 设置状态栏颜色
        window.setStatusBarColor(Color.parseColor("#7067E2"));
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

    public void setStatusBarUpperAPI19(Activity activity) {
        Window window = activity.getWindow();

        // FLAG_TRANSLUCENT_STATUS 这个属性设置应用内容可以占用状态栏高度(支持android系统 4.4 以上)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        ViewGroup mContentView = activity.findViewById(Window.ID_ANDROID_CONTENT);
        int statusBarHeight = getStatusBarHeight();

        View mTopView = mContentView.getChildAt(0);
        if (mTopView != null && mTopView.getLayoutParams() != null &&
                mTopView.getLayoutParams().height == statusBarHeight) {
            // 避免重复添加 View
            mTopView.setBackgroundColor(Color.parseColor("#7067E2"));
            return;
        }

        // 使 ChildView 预留空间
        if (mTopView != null) {
            ViewCompat.setFitsSystemWindows(mTopView, true);
        }

        // 添加 View
        mTopView = new View(activity);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        mTopView.setBackgroundColor(Color.parseColor("#7067E2"));
        mContentView.addView(mTopView, 0, layoutParams);
    }

    private int getStatusBarHeight() {
        Resources resources = getResources();
        int result = 0;
        int resId = resources.getIdentifier("status_bar_height","dimen","android");
        if(resId > 0) {
            result = resources.getDimensionPixelSize(resId);
        }
        return result;
    }
}
