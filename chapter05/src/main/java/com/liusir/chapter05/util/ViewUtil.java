package com.liusir.chapter05.util;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
    public static void hideOneInputMethod(Activity act, View v) {
    //    从系统服务中获取输入法管理器
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
    //    关闭屏幕上的输入法软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
