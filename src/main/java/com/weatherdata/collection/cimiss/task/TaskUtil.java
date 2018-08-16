package com.weatherdata.collection.cimiss.task;

import sun.applet.Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TaskUtil {

    private static String  CORN_FORMAT_PATTERN="ss mm HH dd MM ? yyyy";
    public static String timeToCorn(String timeStr){
        try{

            SimpleDateFormat  timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
            timeFormat.setTimeZone(timeZone);
            Date date = timeFormat.parse(timeStr);
            SimpleDateFormat sdf = new SimpleDateFormat(CORN_FORMAT_PATTERN);
            String corn =sdf.format(date);
            return corn;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String timeStr ="20180812104000";
        System.out.println(timeToCorn(timeStr));
    }
}
