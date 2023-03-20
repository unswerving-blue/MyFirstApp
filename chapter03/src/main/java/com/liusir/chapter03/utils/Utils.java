package com.liusir.chapter03.utils;

import android.content.Context;

public class Utils {
//    根据手机的分辨率从dp的单位 转化为px {像素}
    public static int dipToPx(Context context,int dpValue) {
//       获取当前手机的像素密度（1个dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (scale * dpValue + 0.5f);//四舍五入取整
    }
}
