package com.liusir.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TextColorActivity extends AppCompatActivity {


    private static final String TAG = "TextColorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);
        /*从布局文件中获取名叫tv_code_system的文本视图*/
        TextView tv_hello = (TextView) findViewById(R.id.tv_hello);
        /*将tv_hello的文字颜色设置为蓝色*/
        tv_hello.setTextColor(Color.BLUE);
        /*从布局文件中获取名叫tv_hello2的文本视图*/
        TextView tv_hello2 = (TextView) findViewById(R.id.tv_hello2);
        /*将tv_hello2的文字颜色设置为绿色*/
        tv_hello2.setTextColor(0xff00ff00);


        /*设置背景颜色*/
        /*从布局文件中获取名叫tv_background1的文本视图*/
        TextView tv_background1 = (TextView) findViewById(R.id.tv_background1);
        /*将tv_background的背景颜色设置为红色*/
        /*颜色来自系统*/
        tv_background1.setBackgroundColor(Color.RED);
        /*从布局文件中获取名叫tv_background2的文本视图*/
        TextView tv_background2 = (TextView) findViewById(R.id.tv_background2);
        /*将tv_background2的背景颜色设置为紫色*/
        /*颜色来自资源文件*/
        tv_background2.setBackgroundResource(R.color.black);


    }
}