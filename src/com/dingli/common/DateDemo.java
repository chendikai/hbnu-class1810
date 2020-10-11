package com.dingli.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        /*
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        System.out.println(simpleDateFormat.format(date.getTime()));
        */

        Calendar calendar = Calendar.getInstance();  // 创建日期类对象
        System.out.println(calendar.get(Calendar.YEAR)); // 获取年份
        System.out.println(calendar.get(Calendar.MONTH) + 1); // 获取月份
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 获取日期

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
