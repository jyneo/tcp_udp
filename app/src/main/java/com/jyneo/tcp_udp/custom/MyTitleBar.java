package com.jyneo.tcp_udp.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 继承RelativeLayout，自定义标题栏
 * Created by yj2595 on 2018/4/9.
 */

public class MyTitleBar extends RelativeLayout {
    private Context context;
    // 定义三个控件
    private MyButton btnLeft;
    private TextView tvTitle;
    private MyButton btnRight;

    // 定义左侧控件的接口
    private OnClickListenerLeft onClickListenerLeft = null;

    // 定义右侧控件的接口
    private OnClickListenerRight onClickListenerRight = null;

    public interface OnClickListenerLeft {
        // 左侧点击事件
        void onClick(View v);
    }

    public interface OnClickListenerRight {
        // 右侧点击事件
        void onClick(View v);
    }

    /**
     * 为左侧控件绑定事件
     * @param onClickListenerLeft:
     */
    public void setOnClickListenerLeft(OnClickListenerLeft onClickListenerLeft) {
        this.onClickListenerLeft = onClickListenerLeft;
    }

    /**
     * 为右侧控件绑定事件
     * @param onClickListenerRight:
     */
    public void setOnClickListenerRight(OnClickListenerRight onClickListenerRight) {
        this.onClickListenerRight = onClickListenerRight;
    }

    public MyTitleBar(Context context) {
        this(context, null);
    }

    public MyTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 构造器
     * @param context:
     * @param attrs:
     * @param defStyle:
     */
    public MyTitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        // 设置RelativeLayout的布局
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        // 设置默认的背景色
        setBackgroundColor(Color.parseColor("#B674D2"));
        init();
    }

    private void init() {
        // 初始化左侧MyButton
        btnLeft = new MyButton(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        // 垂直居中
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        // 设置距离左侧10dp
        layoutParams.leftMargin = dp2px(context, 20);
        layoutParams.topMargin = dp2px(context, 10);
        layoutParams.bottomMargin = dp2px(context, 10);
        btnLeft.setLayoutParams(layoutParams);
        btnLeft.setTextSize(18); // 设置字体大小,默认为18
        btnLeft.setTextColor(Color.WHITE); // 默认字体颜色为白色
        btnLeft.setTextColorSelected("#909090"); // 按下后的字体颜色
        // 定义其点击事件
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerLeft != null) {
                    onClickListenerLeft.onClick(v);
                }
            }
        });

        // 初始化中间标题控件
        tvTitle = new TextView(context);
        layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        // 使其处于父控件的中间位置，也有一些APP的标题偏左，可根据项目需要自行调整，也可动态设置
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        tvTitle.setLayoutParams(layoutParams);
        // 设置标题文字颜色
        tvTitle.setTextColor(Color.WHITE);
        // 设置标题文字大小
        tvTitle.setTextSize(18); // 默认为18

        // 初始化右侧MyButton
        btnRight = new MyButton(context);
        layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.rightMargin = dp2px(context, 20);
        // 垂直居中
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        // 居于父控件的右侧
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btnRight.setLayoutParams(layoutParams);
        btnRight.setTextSize(18); // 默认为18
        btnRight.setVisibility(View.GONE); // 默认隐藏右侧控件
        btnRight.setTextColor(Color.WHITE);
        btnRight.setTextColorSelected("#909090");
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerRight != null) {
                    onClickListenerRight.onClick(v);
                }
            }
        });

        // 分别将三个控件加入到容器中
        addView(btnLeft);
        addView(tvTitle);
        addView(btnRight);
    }

    /**
     * 设置标题栏的背景色 String
     * @param backColorS 参数
     */
    public void setBackColor(String backColorS) {
        setBackgroundColor(Color.parseColor(backColorS));
    }

    /**
     * 设置标题栏的背景色 int
     * @param backColorI 参数
     */
    public void setBackColor(int backColorI) {
        setBackgroundColor(backColorI);
    }

    /**
     * 设置左侧控件显示的文字
     * @param leftText 参数
     */
    public void setLeftText(String leftText) {
        btnLeft.setText(leftText);
    }

    /**
     * 设置左侧控件的背景图
     * @param leftBackImage 参数
     */
    public void setLeftBackImage(int leftBackImage) {
        if (leftBackImage != 0) {
            btnLeft.setBackGroundImage(leftBackImage);
        }
    }

    /**
     * 设置左侧控件选中的背景图
     * @param leftBackImageSelected 参数
     */
    public void setLeftBackImageSelected(int leftBackImageSelected) {
        if (leftBackImageSelected != 0) {
            btnLeft.setBackGroundImageSelected(leftBackImageSelected);
        }
    }

    /**
     * 设置左侧控件显示属性，默认为显示
     * @param leftVisible 参数
     */
    public void setLeftVisible(boolean leftVisible) {
        btnLeft.setVisibility(leftVisible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置左侧控件显示的字体大小
     * @param leftTextSize 参数
     */
    public void setLeftTextSize(float leftTextSize) {
        btnLeft.setTextSize(leftTextSize);
    }

    /**
     * 设置中间控件显示属性，默认为显示
     * @param titleVisible 参数
     */
    public void setTitleVisible(boolean titleVisible) {
        tvTitle.setVisibility(titleVisible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置中间控件的文字
     * @param titleText 参数
     */
    public void setTitleText(String titleText) {
        tvTitle.setText(titleText);
    }

    /**
     * 设置中间控件的文字的大小
     * @param titleTextSize 参数
     */
    public void setTitleTextSize(float titleTextSize) {
        tvTitle.setTextSize(titleTextSize);
    }

    /**
     * 设置右侧控件显示的文字
     * @param rightText 参数
     */
    public void setRightText(String rightText) {
        btnRight.setText(rightText);
    }

    /**
     * 设置右侧控件的背景图
     * @param rightBackImage 参数
     */
    public void setRightBackImage(int rightBackImage) {
        if (rightBackImage != 0) {
            btnRight.setBackGroundImage(rightBackImage);
        }
    }

    /**
     * 设置右侧控件选中的背景图
     * @param rightBackImageSelected 参数
     */
    public void setRightBackImageSelected(int rightBackImageSelected) {
        if (rightBackImageSelected != 0) {
            btnRight.setBackGroundImageSelected(rightBackImageSelected);
        }
    }

    /**
     * 设置右侧控件显示的字体大小
     * @param rightTextSize 参数
     */
    public void setRightTextSize(float rightTextSize) {
        btnRight.setTextSize(rightTextSize);
    }

    /**
     * 设置右侧控件显示属性，默认为隐藏
     * @param rightVisible 参数
     */
    public void setRightVisible(boolean rightVisible) {
        btnRight.setVisibility(rightVisible ? View.VISIBLE : View.GONE);
    }

    // 定义一个私有方法dp2px
    private int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
}
