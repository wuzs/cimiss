package com.weatherdata.collection.cimiss.scheduler;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {

    @Autowired
    private JobFactory jobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);

        schedulerFactoryBean.setStartupDelay(20);

        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler(){
        return  schedulerFactoryBean().getScheduler();
    }


}
