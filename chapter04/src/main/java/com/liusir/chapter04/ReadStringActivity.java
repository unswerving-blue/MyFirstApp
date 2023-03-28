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

        /*利用字符串res/string 获取字符串*/
//      获取show TextView
        TextView tvShow = (TextView) findViewById(R.id.tv_show);
        String weather = getString(R.string.weather_str);
        tvShow.setText(weather);


        /*利用元数据获取字符串*/

        TextView tvMeta = (TextView) findViewById(R.id.tv_meta);
        //调用getPackageManager方法获得当前应用的包管理器
        PackageManager pm = getPackageManager();
        try {
//          调用包管理器的getActivityInfo方法获得当前活动的信息对象
            ActivityInfo act = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Bundle metaData = act.metaData; //获取活动附加的元数据信息
            String wearther = metaData.getString("weather");//从包裹中取出名为weather的字符串
            tvMeta.setText("来自元数据的信息：今天天气："+wearther);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}