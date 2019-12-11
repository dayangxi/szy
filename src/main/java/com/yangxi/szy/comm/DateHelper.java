package com.yangxi.szy.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String curDateStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    public static String curTimeStr() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(new Date());
    }

    public static String targetDateStr(int delta) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date d = new Date();
        return df.format(new Date(d.getTime() + delta * 24 * 60 * 60 * 1000));
    }
}
