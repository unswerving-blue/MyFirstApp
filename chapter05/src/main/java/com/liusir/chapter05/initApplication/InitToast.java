package com.liusir.chapter05.initApplication;

import android.app.Application;

import com.hjq.toast.Toaster;

public class InitToast  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    //    初始化框架
        Toaster.init(this);
    }
}
