package com.liusir.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liusir.chapter03.utils.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;
    private Button btnTest;
    private Button btnDisable;
    private Button btnEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        btnEnable = (Button) findViewById(R.id.btn_enable);
        btnDisable = (Button) findViewById(R.id.btn_disable);
        btnTest = (Button) findViewById(R.id.btn_test);
        result = (TextView) findViewById(R.id.tv_result);

        btnEnable.setOnClickListener(this);
        btnDisable.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enable:{
                btnTest.setEnabled(true);
                btnTest.setTextColor(Color.BLACK);
                break;
            }
            case R.id.btn_disable:{
                btnTest.setEnabled(false);
                btnTest.setTextColor(Color.LTGRAY);
                break;
            }
            case R.id.btn_test:{
                String desc = String.format("%s 点击了: %s", DateUtil.getNowTime(), btnTest.getText());
                result.setText(desc);
                break;
            }
        }
    }
}