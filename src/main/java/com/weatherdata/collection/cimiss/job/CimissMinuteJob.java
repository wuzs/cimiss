package com.weatherdata.collection.cimiss.job;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.weatherdata.collection.cimiss.cached.Memcached;
import com.weatherdata.collection.cimiss.model.CimissSyncTask;
import com.weatherdata.collection.cimiss.scheduler.CollDataScheduler;
import com.weatherdata.collection.cimiss.service.CollectionTaskService;
import com.weatherdata.collection.cimiss.task.TaskUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sun.awt.geom.AreaOp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CimissMinuteJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("minute");
        CollDataScheduler collDataScheduler =(CollDataScheduler) jobExecutionContext.getJobDetail().getJobDataMap().get("collDataScheduler");

        CollectionTaskService collectionTaskService = (CollectionTaskService) jobExecutionContext.getJobDetail().getJobDataMap().get("collectionTaskService");
        System.out.println(collDataScheduler);

        Memcached memcached = (Memcached) jobExecutionContext.getJobDetail().getJobDataMap().get("memcached");
        String key =jobExecutionContext.getJobDetail().getKey().getName();
        String groupname = jobExecutionContext.getTrigger().getJobKey().getGroup();
        System.out.println("GROUP:"+groupname);
        CimissSyncTask cimissSyncTask=(CimissSyncTask) memcached.getObejct(key);
        //System.out.println();
        nextCorn(collectionTaskService,cimissSyncTask,collDataScheduler,memcached,groupname);
    }

    private void nextCorn( CollectionTaskService collectionTaskService,CimissSyncTask cimissSyncTask,CollDataScheduler collDataScheduler,Memcached memcached,String group){

        String taskStartTime = cimissSyncTask.getTaskStartTime();
        Integer interval = cimissSyncTask.getNextTaskStartTimeInterval();
        Integer delay= cimissSyncTask.getTaskStartTimeDelay();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try{
            ///TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
            //sdf.setTimeZone(timeZone);
            Date date = sdf.parse(taskStartTime);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE,interval+delay);
            date=calendar.getTime();
            String nextTaskStartTime = sdf.format(date);
            String corn =TaskUtil.timeToCorn(nextTaskStartTime);
            System.out.println(corn);
            cimissSyncTask.setTaskStartTime(nextTaskStartTime);
            memcached.setObject(cimissSyncTask.getTaskCode(),cimissSyncTask);
            collDataScheduler.modifyJobTime(cimissSyncTask.getTaskCode(),group,corn);

            collectionTaskService.saveCimissSyncTask(cimissSyncTask);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
