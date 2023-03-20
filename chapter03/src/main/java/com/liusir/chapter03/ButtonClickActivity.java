package com.liusir.chapter03;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liusir.chapter03.utils.DateUtil;

public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        /*获取要显示的TextView*/
        result = (TextView) findViewById(R.id.tv_result);
        /*获取Btn_click_single*/
        Button btn_click_single = (Button) findViewById(R.id.btn_click_single);
        /*给btn_click_single设置点击监听器,一旦用户点击按钮,就会触发监听器的Onclick方法*/
        btn_click_single.setOnClickListener(new MyOnClickListener(this.result));

        /*获取btn_click_public*/
        Button btnClickPublic = (Button) findViewById(R.id.btn_click_public);
        /*本类实现View.OnclickListenner 给btnClickPublic注册到本类上  */
        btnClickPublic.setOnClickListener(this);

        /*获取BtnClickLong的按钮*/
        Button btnClickLong = (Button) findViewById(R.id.btn_click_long);
        /*给BtnClickLong注册长点击*/
        btnClickLong.setOnLongClickListener(view -> {
            if(view.getId() == R.id.btn_click_long){
                String desc = String.format("%s 长按了按钮: %s:", DateUtil.getNowTime(), ((Button) view).getText());
                result.setText(desc);
            }
            return true;
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_click_public) {
            Log.d("ButtonClickActivity", "btn_click_public_Yes");
            String desc = String.format("%s 你点击了按钮 %s:", DateUtil.getNowTime(), ((Button) view).getText());
            result.setText(desc);
        }
    }

    static class MyOnClickListener implements View.OnClickListener {
        private final TextView result;

        public MyOnClickListener(TextView result) {
            this.result = result;
        }

        @Override
        public void onClick(View view) {
            String desc = String.format("%s 你点击了按钮: %s", DateUtil.getNowTime(), ((Button) view).getText());
            result.setText(desc);
        }
    }


}