package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="CIMISS_DATA_HOUR")
@Entity
@Data
public class CimissDataHour implements Serializable{

    private static final long serialVersionUID = 5061442292822290028L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID",columnDefinition = "int COMMENT'主键 自增'")
    private Integer id;

    @Column(name="STATION_NUM",columnDefinition = "varchar(25) COMMENT'站点编号'")
    private String stationNum;

    @Column(name="STATION_NAME",columnDefinition = "varchar(50) COMMENT'站点名称'")
    private String stationName;

    @Column(name="LONGITUDE",columnDefinition = "float COMMENT'经度'")
    private Float longitude;

    @Column(name="LATITUDE",columnDefinition = "float COMMENT'纬度'")
    private Float latitude;

    @Column(name="OBSERVE_TIME",columnDefinition = "datetime COMMENT'观测站数据时间'")
    private Date observeTime;

    @Column(name="SYNC_TIME",columnDefinition = "datetime COMMENT'数据采集时间'")
    private Date syncTime;

    @Column(name="PRESSURE",columnDefinition = "float COMMENT '气压'")
    private Float pressure;

    @Column(name="SEA_LEVEL_PRESSURE",columnDefinition = "float COMMENT'海平面气压'")
    private Float seaLevelPressure;

    @Column(name="PRESSURE_CHANGE_3H",columnDefinition = "float COMMENT'3小时变压'")
    private Float pressureChange3H;

    @Column(name="PRESSURE_CHANGE_24H",columnDefinition = "float COMMENT'24小孩变压'")
    private Float pressureChange24H;

    @Column(name="MAX_PRESSURE",columnDefinition = "float COMMENT'最高气压'")
    private  Float maxPressure;

    @Column(name="MAX_PRESSURE_TIME",columnDefinition = "float COMMENT'最高气压出现时间'")
    private Date maxPressureTime;

    @Column(name = "TEMP",columnDefinition = "float COMMENT'气温'")
    private Float temp;

    @Column(name="MAX_TEMP",columnDefinition = "float COMMENT'最高气温'")
    private Float maxTemp;

    @Column(name="MAX_TEMP_TIME",columnDefinition = "datetime COMMENT'最高气温出现时间'")
    private Date maxTempTime;

    @Column(name="MIN_TEMP",columnDefinition = "float COMMENT'最低气温'")
    private Float minTemp;

    @Column(name="MIN_TEMP_TIME",columnDefinition = "datetime COMMENT'最低气温出现时间'")
    private Date minTempTime;

    @Column(name = "TEMP_CHANGE_24H",columnDefinition = "varchar(100) COMMENT'过去24小时变温'")
    private String tempChange24H;

    @Column(name="MAX_TEMP_24H",columnDefinition = "float COMMENT'过去24小时最高温'")
    private Float maxTemp24H;

    @Column(name="DEW_POINT_TEMP",columnDefinition = "float COMMENT'漏点温度'")
    private Float dewPointTemp;

    @Column(name="HUMIDITY",columnDefinition = "float COMMENT'相对湿度'")
    private Float humidity;

    @Column(name="MIN_HUMIDITY",columnDefinition = "float COMMENT'最小相对湿度'")
    private  Float minHumidity;

    @Column(name="MIN_HUMIDITY_TIME",columnDefinition = "datetime COMMENT'最小相对湿度出现时间'")
    private Date minHumidityTime;

    @Column(name="WATER_PRESSURE",columnDefinition = "float COMMENT '水汽压'")
    private Float waterPressure;

    @Column(name="RAIN_AMOUNT_1H",columnDefinition = "float COMMENT'过去1小时降水量'")
    private Float rainAmount1H;

    @Column(name="RAIN_AMOUNT_3H",columnDefinition = "float COMMENT'过去3小时降水量'")
    private Float rainAmount3H;

    @Column(name="RAIN_AMOUNT_6H",columnDefinition = "float COMMENT'过去6小时降水量'")
    private Float rainAmount6H;

    @Column(name="RAIN_AMOUNT_12H",columnDefinition = "float COMMENT'过去12小时降水量'")
    private Float rainAmount12H;

    @Column(name="RAIN_AMOUNT_24H",columnDefinition = "float COMMENT'过去24小时降水量'")
    private Float rainAmount24H;

    @Column(name="RAIN_ART_ENC_OBSERVE_PERIOD",columnDefinition = "varchar(255) COMMENT'人工加密观测降水量描述周期'")
    private String rainArtEncObservePeriod;

    @Column(name="RAIN_AMOUNT",columnDefinition = "float COMMENT'降水量'")
    private Float rainAmount;

    @Column(name="EVAPORATION",columnDefinition = "varchar(255) COMMENT'蒸发（大型）'")
    private String evaporation;

    @Column(name="WIND_DIRECTION_2M",columnDefinition = "float COMMENT'2分钟平均风向'")
    private  Float windDirection2M;

    @Column(name="WIND_SPEED_2M",columnDefinition = "float COMMENT'2分钟平均风速'")
    private Float windSpeed2M;

    @Column(name="WIND_DIRECTION_10M",columnDefinition = "float COMMENT'10分钟平均风向'")
    private  Float windDirection10M;

    @Column(name="WIND_SPEED_10M",columnDefinition = "float COMMENT'10分钟平均风速'")
    private Float windSpeed10M;

    @Column(name="MAX_WIND_SPEED_DIRECTION",columnDefinition = "float COMMENT'最大风速风向'")
    private Float maxWindSpeedDirection;

    @Column(name = "MAX_WIND_SPEED",columnDefinition = "float COMMENT'最大风速'")
    private Float maxWindSpeed;

    @Column(name="MAX_WIND_SPEED_TIME",columnDefinition = "datetime COMMENT'最大风速出现时间'")
    private Date maxWindSpeedTime;

    @Column(name="INSTANT_WIND_SPEED",columnDefinition = "float COMMENT'瞬时风速'")
    private Float instantWindSpeed;

    @Column(name="INSTANT_WIND_DIRECTION",columnDefinition = "float COMMENT'瞬时风向'")
    private Float instantWindDirection;

    @Column(name = "VAST_WIND_DIRECTION",columnDefinition = "float COMMENT'极大风速风向'")
    private Float vastWindDirection;

    @Column(name="VAST_WIND_SPEED",columnDefinition = "float COMMENT'极大风速'")
    private Float vastWindSpeed;

    @Column(name="VAST_WIND_TIME",columnDefinition = "datetime COMMENT '极大风速出现时间'")
    private Date  vastWindTime;

    @Column(name="VAST_WIND_DIRECTION_6H",columnDefinition = "float COMMENT'过去6小时极大瞬时风向'")
    private Float vastWindDirection6H;

    @Column(name="VAST_WIND_SPEED_6H",columnDefinition = "float COMMENT'过去6小时极大瞬时风速'")
    private  Float vastWindSpeed6H;

    @Column(name="VAST_WIND_DIRECTION_12H",columnDefinition = "float COMMENT'过去12小时极大瞬时风向'")
    private Float vastWindDirection12H;

    @Column(name="VAST_WIND_SPEED_12H",columnDefinition = "float COMMENT'过去12小时极大瞬时风速'")
    private  Float vastWindSpeed12H;

    @Column(name="GROUND_TEMP",columnDefinition = "float COMMENT'地面温度'")
    private Float groundTemp;

    @Column(name="MAX_GROUND_TEMP",columnDefinition = "float COMMENT'最高地面温度'")
    private Float maxGroundTemp;

    @Column(name="MAX_GROUND_TEMP_TIME",columnDefinition = "datetime COMMENT'最高地面温度出现时间'")
    private Date maxGroundTempTime;


    @Column(name="MIN_GROUND_TEMP",columnDefinition = "float COMMENT'最低地面温度'")
    private Float minGroundTemp;

    @Column(name="MIN_GROUND_TEMP_TIME",columnDefinition = "datetime COMMENT'最低地面温度出现时间'")
    private Date minGroundTempTime;

    @Column(name="MIN_GROUND_TEMP_12H",columnDefinition = "float COMMENT'过去12小时最低地面温度'")
    private Float minGroundTemp12H;

    @Column(name="GROUND_TEMP_5CM",columnDefinition = "float COMMENT'5cm地温'")
    private Float groundTemp5cm;

    @Column(name="GROUND_TEMP_10CM",columnDefinition = "float COMMENT'10cm地温'")
    private Float groundTemp10cm;

    @Column(name="GROUND_TEMP_15CM",columnDefinition = "float COMMENT'15cm地温'")
    private Float groundTemp15cm;
    @Column(name="GROUND_TEMP_20CM",columnDefinition = "float COMMENT'20cm地温'")
    private Float groundTemp20cm;
    @Column(name="GROUND_TEMP_40CM",columnDefinition = "float COMMENT'40cm地温'")
    private Float groundTemp40cm;
    @Column(name="GROUND_TEMP_80CM",columnDefinition = "float COMMENT'80cm地温'")
    private Float groundTemp80cm;
    @Column(name="GROUND_TEMP_160CM",columnDefinition = "float COMMENT'160cm地温'")
    private Float groundTemp160cm;
    @Column(name="GROUND_TEMP_320CM",columnDefinition = "float COMMENT'320cm地温'")
    private Float groundTemp320cm;

    @Column(name="GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'草面(雪面)温度'")
    private Float grassSurfaceTemp;

    @Column(name = "MAX_GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'草面(雪面)最高温度'")
    private Float maxGrassSurfaceTemp;

    @Column(name = "MAX_GRASS_SURFACE_TEMP_TIME",columnDefinition = "datetime COMMENT'草面(雪面)最高温度出现时间'")
    private Date maxGrassSurfaceTempTime;


    @Column(name = "MIN_GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'草面(雪面)最低温度'")
    private Float minGrassSurfaceTemp;

    @Column(name = "MIN_GRASS_SURFACE_TEMP_TIME",columnDefinition = "datetime COMMENT'草面(雪面)最低温度出现时间'")
    private Date minGrassSurfaceTempTime;

    @Column(name="VISIBILITY_1M",columnDefinition = "float COMMENT'1分钟平均水平能见度'")
    private Float visibility1M;

    @Column(name="VISIBILITY_10M",columnDefinition = "float COMMENT'10分钟平均水平能见度'")
    private Float visibility10M;

    @Column(name="MIN_VISIBILITY",columnDefinition = "float COMMENT'最小水平能见度'")
    private Float minVisibility;

    @Column(name="MIN_VISIBILITY_TIME",columnDefinition = "datetime COMMENT'最小水平能见度'")
    private Date minVisibilityTime;

    @Column(name = "VISIBILITY",columnDefinition = "float COMMENT'水平能见度（人工）'")
    private Float visibility;

    @Column(name="TOTAL_CLOUD_AMOUNT",columnDefinition = "float COMMENT'总云量'")
    private Float totalCloudAmount;

    @Column(name="LOW_CLOUD",columnDefinition = "float COMMENT'低云量'")
    private Float lowCloud;

    @Column(name="CLOUD",columnDefinition = "float COMMENT '云量'")
    private Float cloud;

    @Column(name="CLOUD_BOTTOM_HEIGHT",columnDefinition = "float COMMENT'云底高度'")
    private Float cloudBottomHeight;

    @Column(name = "CLOUDY_ONE",columnDefinition = "varchar(100) COMMENT'云状1'")
    private String cloudyOne;

    @Column(name = "CLOUDY_TWO",columnDefinition = "varchar(100) COMMENT'云状2'")
    private String cloudyTwo;

    @Column(name = "CLOUDY_THREE",columnDefinition = "varchar(100) COMMENT'云状3'")
    private String cloudyThree;
    @Column(name = "CLOUDY_FOUR",columnDefinition = "varchar(100) COMMENT'云状4'")
    private String cloudyFour;
    @Column(name = "CLOUDY_FIVE",columnDefinition = "varchar(100) COMMENT'云状5'")
    private String cloudyFive;
    @Column(name = "CLOUDY_SIX",columnDefinition = "varchar(100) COMMENT'云状6'")
    private String cloudySix;
    @Column(name = "CLOUDY_SEVEN",columnDefinition = "varchar(100) COMMENT'云状7'")
    private String cloudySeven;
    @Column(name = "CLOUDY_EIGHT",columnDefinition = "varchar(100) COMMENT'云状8'")
    private String cloudyEight;

    @Column(name="LOW_CLOUDY",columnDefinition = "varchar(100) COMMENT'低云状'")
    private String lowCloudy;

    @Column(name="MIDDLE_CLOUDY",columnDefinition = "varchar(100) COMMENT'中云状'")
    private String middleCloudy;

    @Column(name="HIGH_CLOUDY",columnDefinition = "varchar(100) COMMENT'高云状'")
    private String highCloudy;

    @Column(name="WEATHER",columnDefinition = "varchar(100) COMMENT '现在天气'")
    private String weather;

    @Column(name="WEATHER_DESC_CYCLE",columnDefinition = "varchar(100) COMMENT'过去天气描述事件周期'")
    private String weatherDescCycle;

    @Column(name="LAST_WEATHER_ONE",columnDefinition = "varchar(100) COMMENT'过去天气1'")
    private String lastWeatherOne;

    @Column(name="LAST_WEATHER_TWO",columnDefinition = "varchar(100) COMMENT'过去天气2'")
    private String lastWeatherTwo;

    @Column(name="GROUND_STATE",columnDefinition = "varchar(100) COMMENT'地面状态'")
    private String groundState;

    @Column(name="SNOW_DEEP",columnDefinition = "float COMMENT'积雪深度'")
    private Float snowDeep;

    @Column(name="SNOW_PRESSURE",columnDefinition = "float COMMENT'雪压'")
    private Float snowPressure;

    @Column(name="SOIL_FROZEN_FIRST_LAYER_UPPER",columnDefinition = "float COMMENT'第一冻土层上界值'")
    private Float soilFrozenFirstLayerUpper;

    @Column(name="SOIL_FROZEN_FIRST_LAYER_LOWER",columnDefinition = "float COMMENT'第一冻土层下界值'")
    private Float soilFrozenFirstLayerLower;

    @Column(name="SOIL_FROZEN_SECOND_LAYER_UPPER",columnDefinition = "float COMMENT'第二冻土层上界值'")
    private Float soilFrozenSecondLayerUpper;

    @Column(name="SOIL_FROZEN_SECOND_LAYER_LOWER",columnDefinition = "float COMMENT'第二冻土层下界值'")
    private Float soilFrozenSecondLayerLower;














}
