package com.jyneo.tcp_udp.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

/**
 * 重写Button,自定义Button
 * Created by yj2595 on 2018/4/9.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    // android提供GradientDrawable类，自定义图形shape
    private GradientDrawable gradientDrawable; // 控件的样式

    private String backColorS = null; // 背景色，String类型
    private int backColorI = 0; // 背景色，int类型

    private String backColorSelectedS = null; // 按下后的背景色，String类型
    private int backColorSelectedI = 0; // 按下后的背景色，int类型

    private int backGroundImage = 0; // 背景图，只提供了Id
    private int backGroundImageSelected = 0; // 按下后的背景图，只提供了Id

    private String textColorS = null; // 文字颜色，String类型
    private int textColorI = 0; // 文字颜色，int类型

    private String textColorSelectedS = null; // 按下后的文字颜色，String类型
    private int textColorSelectedI = 0; // 按下后的文字颜色，int类型

    private float radius = 8; // 圆角半径
    private int shape = GradientDrawable.RECTANGLE; // 圆角样式，矩形、圆形等，由于矩形的Id为0，默认为矩形
    private Boolean fillet = false; // 是否设置圆角

    /**
     * 构造器(Context context, AttributeSet attrs)
     * 当项目中遇到这样的场景需要自定义控件的AttributeSet属性
     * 一个自定义控件的有些属性内容是随着外部条件而动态改变的
     * @param context:
     * @param attrs:
     * @param defStyle:
     * */
    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyButton(Context context) {
        this(context, null);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        // 将Button的默认背景色改为透明
        if (fillet) { // 如果按钮是圆角，使用gradientDrawable.setColor(Color.TRANSPARENT);
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setColor(Color.TRANSPARENT);
        } else { // 如果按钮不是圆角，使用setBackgroundColor(Color.TRANSPARENT);
            setBackgroundColor(Color.TRANSPARENT);
        }
        // 设置文字默认居中
        setGravity(Gravity.CENTER);
        // 设置Touch事件
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                // 按下改变样式
                setColor(event.getAction());
                // 此处设置为false，防止Click事件被屏蔽
                return false;
            }
        });
    }

    //改变样式
    private void setColor(int state){
        if (state == MotionEvent.ACTION_DOWN) {
            // 按下
            if (backColorSelectedI != 0) {
                // 先判断是否设置了按下后的背景色int型
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColorSelectedI);
                } else {
                    setBackgroundColor(backColorSelectedI);
                }
            } else if (backColorSelectedS != null) {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.parseColor(backColorSelectedS));
                }else {
                    setBackgroundColor(Color.parseColor(backColorSelectedS));
                }
            }
            //判断是否设置了按下后文字的颜色
            if (textColorSelectedI != 0) {
                setTextColor(textColorSelectedI);
            }else if (textColorSelectedS != null) {
                setTextColor(Color.parseColor(textColorSelectedS));
            }
            // 判断是否设置了按下后的背景图
            if (backGroundImageSelected != 0) {
                setBackgroundResource(backGroundImageSelected);
            }
        }
        if (state == MotionEvent.ACTION_UP) {
            // 抬起
            if (backColorI == 0 && backColorS == null) {
                // 如果没有设置背景色，默认改为透明
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.TRANSPARENT);
                } else {
                    setBackgroundColor(Color.TRANSPARENT);
                }
            } else if(backColorI != 0){
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColorI);
                } else {
                    setBackgroundColor(backColorI);
                }
            } else {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.parseColor(backColorS));
                } else {
                    setBackgroundColor(Color.parseColor(backColorS));
                }
            }
            // 如果没有设置字体颜色，默认为黑色
            if (textColorI == 0 && textColorS == null) {
                setTextColor(Color.BLACK);
            } else if (textColorI != 0) {
                setTextColor(textColorI);
            } else {
                setTextColor(Color.parseColor(textColorS));
            }
            if (backGroundImage != 0) {
                setBackgroundResource(backGroundImage);
            }
        }
    }

    /**
     * 设置按钮的背景色,如果未设置则默认为透明
     * @param backColor:
     */
    public void setBackColor(String backColor) {
        this.backColorS = backColor;
        if (backColor == null) {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.TRANSPARENT);
            } else {
                setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.parseColor(backColor));
            } else {
                setBackgroundColor(Color.parseColor(backColor));
            }
        }
    }

    /**
     * 设置按钮的背景色,如果未设置则默认为透明
     * @param backColor:
     */
    public void setBackColor(int backColor) {
        this.backColorI = backColor;
        if (backColorI == 0) {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.TRANSPARENT);
            } else {
                setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(backColor);
            } else {
                setBackgroundColor(backColor);
            }
        }
    }

    /**
     * 设置按钮按下后的颜色
     * @param backColorSelected:
     */
    public void setBackColorSelected(int backColorSelected) {
        this.backColorSelectedI = backColorSelected;
    }

    /**
     * 设置按钮按下后的颜色
     * @param backColorSelected:
     */
    public void setBackColorSelected(String backColorSelected) {
        this.backColorSelectedS = backColorSelected;
    }



    /**
     * 设置按钮的背景图
     * @param backGroundImage:
     */
    public void setBackGroundImage(int backGroundImage) {
        this.backGroundImage = backGroundImage;
        if (backGroundImage != 0) {
            setBackgroundResource(backGroundImage);
        }
    }

    /**
     * 设置按钮按下的背景图
     * @param backGroundImageSelected:
     */
    public void setBackGroundImageSelected(int backGroundImageSelected) {
        this.backGroundImageSelected = backGroundImageSelected;
    }

    /**
     * 设置按钮圆角半径大小
     * @param radius:
     */
    public void setRadius(float radius) {
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setCornerRadius(radius);
    }

    /**
     * 设置按钮文字颜色
     * @param textColor:
     */
    public void setTextColors(String textColor) {
        this.textColorS = textColor;
        setTextColor(Color.parseColor(textColor));
    }

    /**
     * 设置按钮文字颜色
     * @param textColor:
     */
    public void setTextColori(int textColor) {
        this.textColorI = textColor;
        setTextColor(textColor);
    }

    /**
     * 设置按钮按下的文字颜色
     * @param textColor:
     */
    public void setTextColorSelected(String textColor) {
        this.textColorSelectedS = textColor;
    }

    /**
     * 设置按钮按下的文字颜色
     * @param textColor:
     */
    public void setTextColorSelected(int textColor) {
        this.textColorSelectedI = textColor;
    }

    /**
     * 按钮的形状
     * @param shape:
     */
    public void setShape(int shape) {
        this.shape = shape;
    }

    /**
     * 设置其是否为圆角
     * @param fillet:
     */
    @SuppressWarnings("deprecation")
    public void setFillet(Boolean fillet) {
        this.fillet = fillet;
        if (fillet) {
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            // GradientDrawable.RECTANGLE
            gradientDrawable.setShape(shape);
            gradientDrawable.setCornerRadius(radius);
            setBackgroundDrawable(gradientDrawable);
        }
    }
}
