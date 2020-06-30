package com.zyl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {

    //获取指定天数后的日期字符串
    public static String getDate(int days) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//6表示获得的是6天后的日期
        calendar.add(Calendar.DAY_OF_YEAR, days);
        String date = sdf.format(calendar.getTime());

        return date;
    }

    //获取当前年月日时分秒
    public static String getCurrentTime() {

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = format.format(date);

        return currentTime;
    }

    //获取当前小时数
    public static String getCurrentHour() {

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String currentTime = format.format(date);

        return currentTime;
    }


}
