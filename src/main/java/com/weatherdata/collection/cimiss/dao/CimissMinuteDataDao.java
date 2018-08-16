package com.weatherdata.collection.cimiss.dao;

import com.weatherdata.collection.cimiss.model.CimissDataMinute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CimissMinuteDataDao extends JpaRepository<CimissDataMinute,Integer> {
}
