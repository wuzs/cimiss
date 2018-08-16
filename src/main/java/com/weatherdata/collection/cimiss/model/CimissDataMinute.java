package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="CIMISS_DATA_MINUTE")
@Entity
@Data
public class CimissDataMinute implements Serializable{

    private static final long serialVersionUID = -3364104087311133675L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID",columnDefinition = "int COMMENT'主键 自增'")
    private Integer id;

    @Column(name="STATION_NAME",columnDefinition = "varchar(50) COMMENT'站点名称'")
    private String stationName;

    @Column(name="STATION_NUM",columnDefinition = "varchar(25) COMMENT '站点编号'")
    private String stationNum;

    @Column(name="LONGITUDE",columnDefinition = "float COMMENT '经度'")
    private Float longitude;

    @Column(name="LATITUDE",columnDefinition = "float COMMENT'纬度'")
    private Float latitude;

    @Column(name="OBSERVE_TIME",columnDefinition = "datetime COMMENT'观测站数据时间'")
    private Date observeTime;

    @Column(name="SYNC_TIME",columnDefinition = "datetime COMMENT'数据采集时间'")
    private Date syncTime;

    @Column(name = "MIN_TEMP",columnDefinition = "float COMMENT '最低温'")
    private Float minTemp;

    @Column(name="MIN_TEMP_TIME",columnDefinition = "datetime COMMENT '最低温出现时间' ")
    private Date minTempTime;

    @Column(name="MAX_TEMP",columnDefinition = "float COMMENT'最高温'")
    private Float maxTemp;

    @Column(name="MAX_TEMP_TIME",columnDefinition = "datetime COMMENT'最高温出现时间'")
    private Float maxtTempTime;

    @Column(name="WIND_SPEED_2MIN",columnDefinition = "float COMMENT'2分钟平均风速 m/s'")
    private Float windSpeed2Min;

    @Column(name="WIND_DIRECTION_2MIN",columnDefinition = "float COMMENT'2分钟平均风向'")
    private Float windDirection2Min;

    @Column(name="WIND_SPEED_10MIN",columnDefinition = "float COMMENT '十分钟平均风速'")
    private Float windSpeed10Min;

    @Column(name = "WIND_DIRECTION_10MIN",columnDefinition = "float COMMENT'十分钟平均风向'")
    private Float windDirection10Min;

    @Column(name="MAX_WIND_SPEED",columnDefinition = "float COMMENT'最大风速'")
    private Float maxWindSpeed;

    @Column(name="MAX_WIND_DIRECTION",columnDefinition = "float COMMENT'最大风速风向' ")
    private  Float maxWindDirection;

    @Column(name="MAX_WIND_TIME",columnDefinition = "datetime COMMENT '最大风速出现时间'")
    private Date maxWindTime;

    @Column(name="INSTANT_WIND_SPEED",columnDefinition = "float COMMENT'瞬时风速'")
    private Float instantWindSpeed;

    @Column(name="INSTANT_WIND_DIRECTION",columnDefinition = "float COMMENT'瞬时风向'")
    private Float instantWindDirection;

    @Column(name="VAST_WIND_SPEED",columnDefinition = "float COMMENT'极大风速'")
    private Float vastWindSpeed;

    @Column(name="VAST_WIND_DIRECTION",columnDefinition = "float COMMENT'极大风速风向'")
    private Float vastWindDirection;

    @Column(name="RAIN_AMOUNT",columnDefinition = "float COMMENT'降雨量 mm'")
    private Float rainAmount;

    @Column(name="MIN_HUMIDITY",columnDefinition = "float COMMENT'最小相对湿度 %'")
    private Float minHumidity;

    @Column(name="MIN_HUMIDITY_TIME",columnDefinition = "datetime COMMENT'最小相对湿度出现时间'")
    private Date minHumidityTime;

    @Column(name="MIN_VISIBILITY",columnDefinition = "float COMMENT '最小能见度'")
    private Float minVisibility;

    @Column(name="MIN_VISIBILITY_TIME",columnDefinition = "datetime COMMENT'最小能见度出现时间'")
    private Date minVisibilityTime;

    @Column(name="MAX_PRESSURE",columnDefinition = "float COMMENT'最高气压'")
    private Float maxPressure;

    @Column(name="MAX_PRESSURE_TIME",columnDefinition = "datetime COMMENT'最高气压出现时间'")
    private Date maxPressureTime;

    @Column(name = "MIN_PRESSURE",columnDefinition = "float COMMENT'最低气压'")
    private Float minPressure;

    @Column(name="MIN_PRESSURE_TIME",columnDefinition = "datetime COMMENT'最低气压出现时间'")
    private Date minPressureTime;







}
