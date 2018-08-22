package com.weatherdata.collection.cimiss.controller;

import com.weatherdata.collection.cimiss.cached.Memcached;
import com.weatherdata.collection.cimiss.model.CimissSyncTask;
import com.weatherdata.collection.cimiss.scheduler.CollDataScheduler;
import com.weatherdata.collection.cimiss.service.CollectionTaskService;
import com.weatherdata.collection.cimiss.task.TaskUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CollectionTaskController {

    private static String TASK_SCHEDULER_GROUP="TASK_GROUP";

    @Autowired
    private CollDataScheduler collDataScheduler;

    //public
    @Autowired
    private CollectionTaskService collectionTaskService;

    @Autowired
    private Memcached memcached;

    @RequestMapping("/listTasks")
    public List<CimissSyncTask> listTasks(){
       // collDataScheduler.startJob("00 53 10 12 08 ? 2018","TASK_COLLECTION","TEST","com.weatherdata.collection.cimiss.model.TestScheduler" );
        return collectionTaskService.listTasks();
    }


    @RequestMapping("/getTaskByCode")
    public CimissSyncTask getTaskByCode(@RequestParam("taskCode")String  taskCode){
        CimissSyncTask cimissSyncTask=collectionTaskService.getTaskByTaskCode(taskCode);
        return cimissSyncTask;
    }

    @RequestMapping("/saveTask")
    public CimissSyncTask saveTask(Map<String,Object> params, HttpServletRequest request){
        //String
         String taskCode =request.getParameter("taskCode").toString();
         String dataTime = request.getParameter("dataStartTime").toString();
         String dataInterval = request.getParameter("dataTimeInterval").toString();
         String taskTime = request.getParameter("taskStartTime").toString();
         String taskDelay = request.getParameter("taskTimeDelay").toString();
         String taskInterval = request.getParameter("taskTimeInterval").toString();
         String collType = request.getParameter("collType").toString();
         String isRun = request.getParameter("isRun").toString();// 0关闭  1
         String isRetry = request.getParameter("isRetry").toString();
         String retryTimes = request.getParameter("retryTimes").toString();
         String retryInterval = request.getParameter("retryInterval").toString();
        // String dataType = request.getParameter("dataType").toString();
         String areacodes = request.getParameter("areacodes").toString();
         String stations =request.getParameter("stations").toString();

         CimissSyncTask cimissSyncTask = collectionTaskService.getTaskByTaskCode(taskCode);
         cimissSyncTask.setDataStartTime(dataTime);
         cimissSyncTask.setNextDataTimeInterval(Integer.valueOf(dataInterval));
         cimissSyncTask.setTaskStartTime(taskTime);
         cimissSyncTask.setNextTaskStartTimeInterval(Integer.valueOf(taskInterval));
         cimissSyncTask.setTaskStartTimeDelay(Integer.valueOf(taskDelay));
         cimissSyncTask.setCollType(Integer.valueOf(collType));
         cimissSyncTask.setIsRun(Integer.valueOf(isRun));
         cimissSyncTask.setIsRetry(Integer.valueOf(isRetry));
         cimissSyncTask.setRetryTimes(Integer.valueOf(retryTimes));
         cimissSyncTask.setRetryInterval(Integer.valueOf(retryInterval));
         //cimissSyncTask.setDataType(Integer.valueOf(dataType));
         cimissSyncTask.setAreacodes(areacodes);
         cimissSyncTask.setStationTypes(stations);
         collectionTaskService.saveCimissSyncTask(cimissSyncTask);

         if(1 == cimissSyncTask.getIsRun()){//任务启动
             Boolean flag = collDataScheduler.isInJob(TASK_SCHEDULER_GROUP, cimissSyncTask.getTaskCode());

             //计算任务时间
             SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
             try{
               //  TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                 TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
                 sdf.setTimeZone(timeZone);
                 Date date = sdf.parse(cimissSyncTask.getTaskStartTime());
                 Calendar cal = Calendar.getInstance();
                 cal.setTimeZone(timeZone);
                 cal.setTime(date);
                 cal.add(Calendar.MINUTE,cimissSyncTask.getTaskStartTimeDelay());
                 date  =cal.getTime();
                 String timeStr=sdf.format(date);
                 String corn =TaskUtil.timeToCorn(timeStr);
                 System.out.println(corn);
                 memcached.setObject(cimissSyncTask.getTaskCode(),cimissSyncTask);
                 if(flag){
                     //设置任务执行时间

                     collDataScheduler.modifyJobTime(cimissSyncTask.getTaskCode(),TASK_SCHEDULER_GROUP,corn);
                 }else{
                     if(cimissSyncTask.getDataType()==1){//分钟
                         collDataScheduler.startJob(corn,TASK_SCHEDULER_GROUP,cimissSyncTask.getTaskCode(),"com.weatherdata.collection.cimiss.job.CimissMinuteJob");

                     }else if(cimissSyncTask.getDataType()==2){
                         collDataScheduler.startJob(corn,TASK_SCHEDULER_GROUP,cimissSyncTask.getTaskCode(),"com.weatherdata.collection.cimiss.job.CimissHourJob");

                     }else if(cimissSyncTask.getDataType() ==3){
                         collDataScheduler.startJob(corn,TASK_SCHEDULER_GROUP,cimissSyncTask.getTaskCode(),"com.weatherdata.collection.cimiss.job.CimissDayJob");

                     }

                 }


             }catch (Exception e){
                 e.printStackTrace();
             }
         }else{//关闭任务

             //直接删除
             System.out.println("shanchu ");
             collDataScheduler.deleteJob(cimissSyncTask.getTaskCode(),TASK_SCHEDULER_GROUP);

         }

         return cimissSyncTask;
    }

    /**
     * 验证时间格式,任务采集时间必须是yyyyMMddHHmm
     * @return
     */
    private Boolean validateTaskTime(String timeStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            sdf.parse(timeStr);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }


}
