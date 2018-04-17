package com.jyneo.tcp_udp.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.jyneo.tcp_udp.R;

/**
 *
 * Created by yj2595 on 2018/4/9.
 */

public class BaseActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 重点
        super.setContentView(R.layout.module_include_layout_root);
        setStatusBarColor(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        LinearLayout root_layout = findViewById(R.id.layout_root);
        if (root_layout != null) {
            root_layout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
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
        window.setStatusBarColor(Color.parseColor("#1E90FF"));
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
            mTopView.setBackgroundColor(Color.parseColor("#1E90FF"));
            return;
        }

        // 使 ChildView 预留空间
        if (mTopView != null) {
            ViewCompat.setFitsSystemWindows(mTopView, true);
        }

        // 添加 View
        mTopView = new View(activity);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        mTopView.setBackgroundColor(Color.parseColor("#1E90FF"));
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
