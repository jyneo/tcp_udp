package com.jyneo.tcp_udp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
//        setStatusBarColor(this);
    }

    private void initTitleBar() {
        // 初始化控件
        MyTitleBar myTitleBar = findViewById(R.id.custom_title_bar);
        // 设置背景色
        myTitleBar.setBackColor("#1E90FF");

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
        button_tcp_client.setText("TCP Client");
        button_tcp_client.setBackColor("#1E90FF");
        button_tcp_client.setBackColorSelected("#1E90FF");
        button_tcp_client.setTextColorS("#FFFFFF");
        button_tcp_client.setTextColorSelected("#C0C0C0");
        button_tcp_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TcpClientActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_tcp_server = findViewById(R.id.button_tcp_server);
        button_tcp_server.setText("TCP Server");
        button_tcp_server.setBackColor("#1E90FF");
        button_tcp_server.setBackColorSelected("#1E90FF");
        button_tcp_server.setTextColorS("#FFFFFF");
        button_tcp_server.setTextColorSelected("#C0C0C0");
        button_tcp_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TcpServerActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_udp_client = findViewById(R.id.button_udp_client);
        button_udp_client.setText("UDP Client");
        button_udp_client.setBackColor("#1E90FF");
        button_udp_client.setBackColorSelected("#1E90FF");
        button_udp_client.setTextColorS("#FFFFFF");
        button_udp_client.setTextColorSelected("#C0C0C0");
        button_udp_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UdpClientActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_udp_server = findViewById(R.id.button_udp_server);
        button_udp_server.setText("UDP Server");
        button_udp_server.setBackColor("#1E90FF");
        button_udp_server.setBackColorSelected("#1E90FF");
        button_udp_server.setTextColorS("#FFFFFF");
        button_udp_server.setTextColorSelected("#C0C0C0");
        button_udp_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UdpServerActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_bluetooth = findViewById(R.id.button_bluetooth);
        button_bluetooth.setText("Bluetooth Connect");
        button_bluetooth.setBackColor("#1E90FF");
        button_bluetooth.setBackColorSelected("#1E90FF");
        button_bluetooth.setTextColorS("#FFFFFF");
        button_bluetooth.setTextColorSelected("#C0C0C0");
        button_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(intent);
            }
        });

        MyButton button_smart_config = findViewById(R.id.button_smart_config);
        button_smart_config.setText("Smart Config");
        button_smart_config.setBackColor("#1E90FF");
        button_smart_config.setBackColorSelected("#1E90FF");
        button_smart_config.setTextColorS("#FFFFFF");
        button_smart_config.setTextColorSelected("#C0C0C0");
        button_smart_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmartConfigActivity.class);
                startActivity(intent);
            }
        });
    }


}
