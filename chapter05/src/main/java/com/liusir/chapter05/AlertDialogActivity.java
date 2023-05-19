package com.liusir.chapter05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @Description: 提醒对话框demo
 * @param
 * @return
 * @Author: Charlie liu
 * @Date: 2023/5/17
 */

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {
    
    private TextView tvAlert;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        findViewById(R.id.btn_alert).setOnClickListener(this);
        tvAlert = (TextView) findViewById(R.id.tv_alert);
    }
    
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话的标题文本
        builder.setTitle("尊敬的用户");
        // 设置对话框的内容文本
        builder.setMessage("你真的要卸载我吗？");
        //设置对话框的肯定框按钮文本及其点击监听器
        builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvAlert.setText("虽然依依不舍，但是只能离开了");
            }
        });
    //    设置对话框的否定按钮文本及其点击监听器
        builder.setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvAlert.setText("让我再陪你三百六十五个日夜");
            }
        });
        //根据建造器提醒对话框对象
        AlertDialog alertDialog = builder.create();
        //显示提醒对话框
        alertDialog.show();
    }
}