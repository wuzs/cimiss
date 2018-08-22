package com.weatherdata.collection.cimiss.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRegistered {
    public  static List<Map<String,Object>>  tasks = new ArrayList<>();

    static {

        //分钟数据
        Map<String,Object> minuteDataTask = new HashMap<>();
        minuteDataTask.put("taskName","分钟数据采集");
        minuteDataTask.put("taskCode","TASK_MINIUTE");
        minuteDataTask.put("dataType",1);
        tasks.add(minuteDataTask);


        //小时数据
        Map<String,Object> hourDataTask = new HashMap<>();
        hourDataTask.put("taskName","小时数据采集");
        hourDataTask.put("taskCode","TASK_HOUR");
        hourDataTask.put("dataType",2);
        tasks.add(hourDataTask);

        //日数据
        Map<String,Object> dayDataTask = new HashMap<>();
        dayDataTask.put("taskName","日数据采集");
        dayDataTask.put("taskCode","TASK_DAY");
        dayDataTask.put("dataType",3);

        tasks.add(dayDataTask);

    }

}
