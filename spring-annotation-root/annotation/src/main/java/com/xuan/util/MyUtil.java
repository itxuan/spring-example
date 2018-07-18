package com.xuan.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 11:10  七月
 * @Description:
 * @ModifyBy:
 */
public class MyUtil {


    public static LocalDateTime StringFormatLocalDateTime(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(format, formatter);
        return dateTime;
    }

    public static String localDateTimeFormatString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.of(1995, Month.NOVEMBER, 4, 12, 30,10);
        String formattedDateTime = dateTime.format(formatter); // "1995-11-04 12:30:10"
        return formattedDateTime;
    }

    public static void main(String[] args) {
        System.out.println(StringFormatLocalDateTime("1995-11-04 12:30:10"));
        System.out.println(localDateTimeFormatString(LocalDateTime.now()));
    }
}
