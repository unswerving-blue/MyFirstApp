package com.liusir.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ActionUrlActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_url);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String phone = "1942553240";
        switch (v.getId()) {
            case R.id.btn_dial:
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel" + phone);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.btn_sms:
                intent.setAction(Intent.ACTION_SENDTO);
                Uri uri1 = Uri.parse("smsTO:" + phone);
                intent.setData(uri1);
                startActivity(intent);
                break;
            default:
                intent.setAction("android.intent.action.LiuSir");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
         }
    }
}