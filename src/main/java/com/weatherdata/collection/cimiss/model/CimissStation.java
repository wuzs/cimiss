package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="CIMISS_STATION")
@Entity
@Data
public class CimissStation implements Serializable {

    private static final long serialVersionUID = -3383951661410284398L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID",columnDefinition = "int COMMENT '主键，自增'")
    private Integer id;

    @Column(name="STATION_NAME",length = 50,columnDefinition = "varchar(50) COMMENT '站点名称'")
    private String stationName;

    @Column(name="STATION_NUM",length = 25,columnDefinition = "varchar(25) COMMENT '站点编号'")
    private String stationNum;

    @Column(name="LONGITUDE",columnDefinition = "float COMMENT '经度'")
    private Float longitude;

    @Column(name="LATITUDE",columnDefinition = "float COMMENT '纬度'")
    private Float latitude;


    @Column(name="AREA_CODE",length = 6,columnDefinition = "varchar(6) COMMENT '行政区划编码'")
    private String areaCode;

    @Column(name="STATION_TYPE",columnDefinition = "int COMMENT '站点类型：1 自动站  2 区域站'")
    private  Integer stationType;

    @Column(name="ORDER_INDEX" ,columnDefinition = "int COMMENT '排序'")
    private Integer orderIndex;


}
