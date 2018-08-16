package com.weatherdata.collection.cimiss.service;

import com.weatherdata.collection.cimiss.model.CimissSyncTask;

import java.util.List;

public interface CollectionTaskService {
    public List<CimissSyncTask> listTasks();

    CimissSyncTask getTaskByTaskCode(String taskCode);

    CimissSyncTask saveCimissSyncTask(CimissSyncTask cimissSyncTask);
}
