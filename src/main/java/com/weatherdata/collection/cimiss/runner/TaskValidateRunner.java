package com.weatherdata.collection.cimiss.runner;

import com.weatherdata.collection.cimiss.dao.CollectionTaskDao;
import com.weatherdata.collection.cimiss.model.CimissSyncTask;
import com.weatherdata.collection.cimiss.task.TaskRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 项目启动后检测任务是否存在 如果不存在则默认加到任务表中
 */
@Component
@Order(1)
public class TaskValidateRunner implements ApplicationRunner {

    @Autowired
    private CollectionTaskDao collectionTaskDao;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        List<Map<String,Object>> tasks = TaskRegistered.tasks;
        if(tasks !=null){
            for(Map<String,Object> task: tasks){
                List<CimissSyncTask> codeTasks = collectionTaskDao.getCimissSyncTaskByTaskCode(task.get("taskCode").toString());
                if(codeTasks ==null || codeTasks.size()<=0){
                    CimissSyncTask cimissSyncTask = new CimissSyncTask();
                    cimissSyncTask.setTaskCode(task.get("taskCode").toString());
                    cimissSyncTask.setTaskName(task.get("taskName").toString());
                    cimissSyncTask.setDataType(Integer.valueOf(task.get("dataType").toString()));
                    cimissSyncTask.setIsRun(0);
                    collectionTaskDao.save(cimissSyncTask);
                }

            }

        }
    }
}
