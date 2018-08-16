package com.weatherdata.collection.cimiss.service.impl;

import com.weatherdata.collection.cimiss.dao.CollectionTaskDao;
import com.weatherdata.collection.cimiss.model.CimissSyncTask;
import com.weatherdata.collection.cimiss.service.CollectionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionTaskServiceImpl implements CollectionTaskService {
    @Autowired
    private  CollectionTaskDao collectionTaskDao;

    public List<CimissSyncTask> listTasks(){
        return collectionTaskDao.findAll(new Sort("id"));
    }

    @Override
    public CimissSyncTask getTaskByTaskCode(String taskCode) {
        List<CimissSyncTask> tasks = collectionTaskDao.getCimissSyncTaskByTaskCode(taskCode);
         return tasks==null?null:tasks.get(0);
    }

    @Override
    public CimissSyncTask saveCimissSyncTask(CimissSyncTask cimissSyncTask) {
        return collectionTaskDao.save(cimissSyncTask);
    }
}
