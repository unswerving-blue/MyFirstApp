package com.liusir.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.liusir.chapter03.utils.DateUtil;

public class ButtonStyleActivity extends AppCompatActivity {

    private TextView result;
    private String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        result = (TextView) findViewById(R.id.tv_result);
    }

    public void doClick(View view) {
        String resultText = String.format("%s 你点击了按钮: %s", DateUtil.getNowTime(), ((Button) view).getText());
        result.setText(resultText);
    }
    /*这种方法方法强耦合  不便于日后代码的修改*/
}