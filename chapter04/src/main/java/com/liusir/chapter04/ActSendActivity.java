package com.liusir.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liusir.chapter04.utils.DateUtils;

public class ActSendActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_send);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        findViewById(R.id.btn_send).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActReceiveActivity.class);
//        创建一个新的包裹
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtils.getNowTime());
        bundle.putString("request_content", tv_msg.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}