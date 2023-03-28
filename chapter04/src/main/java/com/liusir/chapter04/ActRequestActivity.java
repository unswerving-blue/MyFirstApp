package com.liusir.chapter04;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liusir.chapter04.utils.DateUtils;

public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String mRequest ="你吃饭了吗？来我家睡觉吧";

    private TextView tvRequest;
    private ActivityResultLauncher<Intent> register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);
        //显示要发送的消息
        tvRequest = (TextView) findViewById(R.id.tv_request);
        tvRequest.setText("待发送的消息为:"+mRequest);

//        获取相应的TextView
        TextView tvResponse = (TextView) findViewById(R.id.tv_response);

//        设置按钮 发送请求
        findViewById(R.id.btn_request).setOnClickListener(this);


//        接受返回的数据  新的回调函数
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result -> {
            if (result != null) {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    Bundle bundle = intent.getExtras();
                    String responseTime = bundle.getString("responseTime");
                    String responseContent = bundle.getString("responseContent");
                    String desc = String.format("收到返回消息：\n应答时间为%s\n应答内容为%s", responseTime, responseContent);
                    tvResponse.setText(desc);
                }
            }
        }));
    }

    @Override
    public void onClick(View v) {
//        创建一个意图对象，跳到指定的活动页面
        Intent intent = new Intent(this, ActResponseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtils.getNowTime());
        bundle.putString("request_content", mRequest);
        intent.putExtras(bundle);
        register.launch(intent);
    }
}