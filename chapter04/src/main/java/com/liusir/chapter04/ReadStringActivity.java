package com.liusir.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class ReadStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_string);
//      res/string 获取字符串     获取show TextView
        TextView tvShow = (TextView) findViewById(R.id.tv_show);
        String weather = getString(R.string.weather_str);
        tvShow.setText(weather);
//        利用元数据获取字符串
        TextView tvMeta = (TextView) findViewById(R.id.tv_meta);
        PackageManager pm = getPackageManager();//获取应用包管理器
        try {
//        从应用包管理器获取当前的活动信息
            ActivityInfo act = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Bundle metaData = act.metaData;//获取活动附加的元数据信息
            String wearther = metaData.getString("weather");//从包裹中取出名为weather的字符串
            tvMeta.setText("来自元数据的信息：今天天气："+wearther);

        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}