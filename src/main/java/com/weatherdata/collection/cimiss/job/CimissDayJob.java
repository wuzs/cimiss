package com.weatherdata.collection.cimiss.job;

import com.weatherdata.collection.cimiss.scheduler.CollDataScheduler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CimissDayJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("minute");
        CollDataScheduler collDataScheduler =(CollDataScheduler) jobExecutionContext.getJobDetail().getJobDataMap().get("collDataScheduler");
        System.out.println(collDataScheduler);
    }
}
