package com.liusir.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liusir.chapter04.utils.DateUtils;

public class ActResponseActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResponse;
    private  String response="爸妈不在家。我还没睡";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_response);
        tvResponse = (TextView) findViewById(R.id.tv_response);
        TextView tvRequest = (TextView) findViewById(R.id.tv_request);
        tvRequest.setText("待返回消息："+response);
//        从上一个页面传来的意图中获取包裹
        Bundle bundle = getIntent().getExtras();
        String requestTime = bundle.getString("request_time");
        String responseContent = bundle.getString("request_content");
        String desc = String.format("收到请求消息:\n请求时间为%s\n请求内容为%s", requestTime, responseContent);
        tvResponse.setText(desc);
        findViewById(R.id.btn_response).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("responseTime", DateUtils.getNowTime());
        bundle.putString("responseContent", response);
        intent.putExtras(bundle);
//        携带意图返回上一个页面。RESULT_OK表示成功
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}