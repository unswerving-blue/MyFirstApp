package com.liusir.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioHorizontalAcitivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView tvSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_horizontal_acitivity);
//       获取单选组  为其设置监听器 一单点击组内的单选按钮,就触发监听器的OnCheckedChanged方法
        ((RadioGroup) findViewById(R.id.rg_sex)).setOnCheckedChangeListener(this);
//        获取tv_sex
        tvSex = (TextView) findViewById(R.id.tv_sex);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String desc = null;
        switch (checkedId) {
            case R.id.rb_male:
                desc = "欢迎小哥哥来临";
                break;
            case R.id.rb_female:
                desc = "欢迎小姐姐来临";
                break;
        }
        tvSex.setText(desc);

    }
}