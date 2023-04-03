package com.liusir.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class switch_acitvity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_acitvity);
//        原生switch
        Switch swichOriginal = (Switch) findViewById(R.id.sw_status);
        swichOriginal.setOnCheckedChangeListener(this);
//        自定义swich
        CheckBox switchSelf = (CheckBox) findViewById(R.id.cb_status);
        switchSelf.setOnCheckedChangeListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String format = String.format("Switch的状态是%s", isChecked ? "开" : "关");
        tvResult.setText(format);
    }
}