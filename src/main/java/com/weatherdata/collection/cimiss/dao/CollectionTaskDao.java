package com.weatherdata.collection.cimiss.dao;

import com.weatherdata.collection.cimiss.model.CimissSyncTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionTaskDao extends JpaRepository<CimissSyncTask,Integer>{

    public List<CimissSyncTask> getCimissSyncTaskByTaskCode(String taskCode);

}
