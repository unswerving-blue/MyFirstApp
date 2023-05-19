package com.liusir.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * @Description: 日期对话框
 * @return
 * @Author: Charlie liu
 * @Date: 2023/5/17
 */

public class DatePickerDialogActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    
    private TextView tvDate;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);
        findViewById(R.id.btn_date).setOnClickListener(this);
        tvDate = (TextView) findViewById(R.id.tv_date);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_date:
                //获取日历的一个实例，里面包含了当前的年月日
                Calendar calender = Calendar.getInstance();
                //构建一个日期对话框，该对话框已经集成了日期选择器
                //DatePickerDialog的第二个构造参数指定了日期监听器
                DatePickerDialog dialog = new DatePickerDialog(this,this,
                        calender.get(Calendar.YEAR),
                        calender.get(Calendar.MONTH),
                        calender.get(Calendar.DAY_OF_MONTH)
                        );
                dialog.show();
                break;
        }
    }
    
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
    //    获取日期对话框设定的年月份
        String desc = String.format("选择的日期是%d年%d月%d日", year, month+1, dayOfMonth);
        tvDate.setText(desc);
    }
}