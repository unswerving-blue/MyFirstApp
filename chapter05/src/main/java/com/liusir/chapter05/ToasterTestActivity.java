package com.liusir.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hjq.toast.ToastParams;
import com.hjq.toast.Toaster;
import com.hjq.toast.style.CustomToastStyle;

public class ToasterTestActivity extends AppCompatActivity implements View.OnClickListener {
    
    private ToastParams params;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toaster_test);
        findViewById(R.id.btn_showToast).setOnClickListener(this);
        params = new ToastParams();
        params.text = "Login Succeed！";
        params.style = new CustomToastStyle(R.layout.toast_success);
    }
    
    @Override
    public void onClick(View v) {
        Toaster.show(params);
    }
}