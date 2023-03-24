package com.liusir.chapter04.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(new Date());
    }
}
