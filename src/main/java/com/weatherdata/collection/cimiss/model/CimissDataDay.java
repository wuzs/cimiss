package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="CIMISS_DATA_DAY")
@Entity
@Data
public class CimissDataDay implements Serializable{

    private static final long serialVersionUID = -2690258061210055932L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID")
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

    @Column(name="PRESSURE",columnDefinition = "float COMMENT'平均气压'")
    private Float pressure;

    @Column(name="SEA_LEVEL_PRESSURE",columnDefinition = "float COMMENT'平均海平面气压'")
    private Float seaLevelPressure;

    @Column(name="MAX_PRESSURE",columnDefinition = "float COMMENT'最高气压'")
    private Float maxPressure;

    @Column(name="MAX_PRESSURE_TIME",columnDefinition = "datetime COMMENT'最高气压出现的时间'")
    private Date maxPressureTime;

    @Column(name="MIN_PRESSURE",columnDefinition = "float COMMENT'最低气压'")
    private Float minPressure;

    @Column(name="MIN_PRESSURE_TIME",columnDefinition = "datetime COMMENT'最低气压出现的时间'")
    private Date minPressureTime;

    @Column(name="WIND_DIRECTION",columnDefinition = "float COMMENT'风向'")
    private Float windDirection;

    @Column(name = "WIND_SPEED",columnDefinition = "float COMMENT'风速'")
    private Float windSpeed;

    @Column(name="MAX_WIND_SPEED",columnDefinition = "float COMMENT'最大风速'")
    private Float maxWindSpeed;

    @Column(name="MAX_WIND_SPEED_DIRECTION",columnDefinition = "float COMMENT'最大风速风向'")
    private Float maxWindSpeedDirection;

    @Column(name="MAX_WIND_SPEED_TIME",columnDefinition = "datetime COMMENT'最大风速出现时间'")
    private Date maxWindSpeedTime;

    @Column(name="VAST_WIND_SPEED",columnDefinition = "float COMMENT'极大风速'")
    private Float vastWindSpeed;

    @Column(name="VAST_WIND_SPEED_DIRECTION",columnDefinition = "float COMMENT'极大风速风向'")
    private Float vastWindSpeedDirection;

    @Column(name="VAST_WIND_SPEED_TIME",columnDefinition ="datetime COMMENT'极大风速出现时间'" )
    private Date vastWindSpeedTime;

    @Column(name="WIND_DIRECTION_2M",columnDefinition = "varchar(20) COMMENT'2分钟平均风向（字符型）'")
    private String windDirection2M;

    @Column(name="WIND_SPEED_2M",columnDefinition = "float COMMENT'平均2分钟风速'")
    private Float windSpeed2M;

    @Column(name="VISIBILITY_10M_PER_HOUR",columnDefinition = "float COMMENT'逐小时10分钟平均能见度'")
    private Float visibility10MPerHour;

    @Column(name="WIND_SPEED_10M",columnDefinition = "float COMMENT'平均10分钟风速'")
    private Float windSpeed10M;

    @Column(name="TEMP",columnDefinition = "float COMMENT'温度'")
    private Float temp;

    @Column(name = "AVG_TEMP",columnDefinition = "float COMMENT'平均气温'")
    private Float avgTemp;

    @Column(name="MAX_TEMP",columnDefinition = "float COMMENT'最高气温'")
    private Float maxTemp;

    @Column(name="MAX_TEMP_TIME",columnDefinition = "datetime COMMENT'最高气温出现时间'")
    private Date maxTempTime;

    @Column(name="MIN_TEMP",columnDefinition = "float COMMENT'最低气温'")
    private Float minTemp;

    @Column(name="MIN_TEMP_TIME",columnDefinition = "datetime COMMENT'最低气温出现时间'")
    private Date minTempTime;

    @Column(name="GROUND_TEMP_5CM",columnDefinition = "float COMMENT'平均5CM地温'")
    private Float groundTemp5CM;

    @Column(name="GROUND_TEMP_10CM",columnDefinition = "float COMMENT'平均10CM地温'")
    private Float groundTemp10CM;

    @Column(name="GROUND_TEMP_15CM",columnDefinition = "float COMMENT'平均15CM地温'")
    private Float groundTemp15CM;
    @Column(name="GROUND_TEMP_20CM",columnDefinition = "float COMMENT'平均20CM地温'")
    private Float groundTemp20CM;
    @Column(name="GROUND_TEMP_40CM",columnDefinition = "float COMMENT'平均40CM地温'")
    private Float groundTemp40CM;
    @Column(name="GROUND_TEMP_80CM",columnDefinition = "float COMMENT'平均80CM地温'")
    private Float groundTemp80CM;
    @Column(name="GROUND_TEMP_160CM",columnDefinition = "float COMMENT'平均160CM地温'")
    private Float groundTemp160CM;
    @Column(name="GROUND_TEMP_320CM",columnDefinition = "float COMMENT'平均320CM地温'")
    private Float groundTemp320CM;

    @Column(name="AVG_GROUND_TEMP",columnDefinition = "float COMMENT'平均地面温度'")
    private Float avgGroundTemp;

    @Column(name="MIN_GROUND_TEMP",columnDefinition = "float COMMENT'最低地面温度'")
    private Float minGroundTemp;

    @Column(name="MIN_GROUND_TEMP_TIME",columnDefinition = "datetime COMMENT'最低地面温度出现时间'")
    private Date minGroundTempTime;


    @Column(name="MAX_GROUND_TEMP",columnDefinition = "float COMMENT'最高地面温度'")
    private Float maxGroundTemp;

    @Column(name="MAX_GROUND_TEMP_TIME",columnDefinition = "datetime COMMENT'最高地面温度出现时间'")
    private Date maxGroundTempTime;

    @Column(name = "GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'平均草面（雪面）温度'")
    private Float grassSurfaceTemp;

    @Column(name = "MAX_GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'最高草面（雪面）温度'")
    private Float maxGrassSurfaceTemp;
    @Column(name = "MAX_GRASS_SURFACE_TEMP_TIME",columnDefinition = "datetime COMMENT'最高草面（雪面）温度出现时间'")
    private Date maxGrassSurfaceTempTime;


    @Column(name = "MIN_GRASS_SURFACE_TEMP",columnDefinition = "float COMMENT'最低草面（雪面）温度'")
    private Float minGrassSurfaceTemp;
    @Column(name = "MIN_GRASS_SURFACE_TEMP_TIME",columnDefinition = "datetime COMMENT'最低草面（雪面）温度出现时间'")
    private Date minGrassSurfaceTempTime;

    @Column(name="HUMIDITY",columnDefinition = "float COMMENT'平均相对湿度'")
    private Float humidity;

    @Column(name="WATER_PRESSURE",columnDefinition = "float COMMENT'平均水汽压'")
    private Float waterPressure;


    @Column(name="MIN_HUMIDITY",columnDefinition = "float COMMENT'最小相对湿度'")
    private Float minHumidity;

    @Column(name="MIN_HUMIDITY_TIME",columnDefinition = "datetime COMMENT'最小相对湿度出现时间'")
    private  Date minHumidityTime;

    @Column(name="SNOW_DEEP",columnDefinition = "float COMMENT'积雪深度'")
    private Float snowDeep;

    @Column(name="EVAPORATE",columnDefinition = "varchar(50) COMMENT'蒸发'")
    private String evaporate;
    @Column(name="EVAPORATE_BIG",columnDefinition = "varchar(50) COMMENT'蒸发(大型)'")
    private String evaporateBig;

    @Column(name="MAX_RAIN_AMOUNT_1H",columnDefinition = "float COMMENT'1小时最大降水量'")
    private Float maxRainAmount1H;

    @Column(name="MAX_RAIN_AMOUNT_DAY_TIME",columnDefinition = "datetime COMMENT'日最大降水量出现时间'")
    private Date maxRainAmountDayTime;

    @Column(name = "RAIN_AMOUNT_20HTO20",columnDefinition = "float COMMENT'20-20时降水量'")
    private Float rainAmount20HTo20;
    @Column(name = "RAIN_AMOUNT_20HTO20_SOLID",columnDefinition = "float COMMENT'20-20时固态降水量'")
    private Float rainAmount20HTo20Solid;


    @Column(name = "RAIN_AMOUNT_08HTO08",columnDefinition = "float COMMENT'08-08时降水量'")
    private Float rainAmount08HTo08;
    @Column(name = "RAIN_AMOUNT_08HTO08_SOLID",columnDefinition = "float COMMENT'08-08时固态降水量'")
    private Float rainAmount08HTO08Solid;


    @Column(name = "RAIN_AMOUNT_20HTO08",columnDefinition = "float COMMENT'20-08时降水量'")
    private Float rainAmount20HTo08;
    @Column(name = "RAIN_AMOUNT_20HTO08_SOLID",columnDefinition = "float COMMENT'20-08时固态降水量'")
    private Float rainAmount20HTo08Solid;

    @Column(name = "RAIN_AMOUNT_08HTO20",columnDefinition = "float COMMENT'08-20时降水量'")
    private Float rainAmount08HTo20;
    @Column(name = "RAIN_AMOUNT_08HTO20_SOLID",columnDefinition = "float COMMENT'08-20时固态降水量'")
    private Float rainAmount08HTo20Solid;

    @Column(name="SNOW_PRESSURE",columnDefinition = "float COMMENT'雪压'")
    private Float snowPressure;


    @Column(name="SUNSHINE_HOURS",columnDefinition = "varchar(50) COMMENT'日照时数'")
    private String sunshineHours;


    @Column(name="AVG_WIND_DIR_SPEED_PER_HOUR",columnDefinition = "float COMMENT'逐小时10分钟平均风向风速'")
    private Float avgWindDirSpeedPerHour;

    @Column(name="AMOUNT_CLOUD",columnDefinition = "float COMMENT'平均总云量'")
    private Float amountCloud;

    @Column(name="LOW_CLOUD",columnDefinition = "float COMMENT'平均低云量'")
    private Float lowCloud;

    @Column(name="MIN_HORIZONTAL_VISIBILITY",columnDefinition = "float COMMENT'最小水平能见度'")
    private Float minHorizontalVisibility;
    @Column(name="MIN_HORIZONTAL_VISIBILITY_TIME",columnDefinition = "float COMMENT'最小水平能见度出现时间'")
    private Float minHorizontalVisibilityTime;

    @Column(name="GROUND_STATE",columnDefinition = "varchar(50) COMMENT'地面状态'")
    private String groundState;

    @Column(name="DEW",columnDefinition = "varchar(50) COMMENT'露'")
    private String dew;

    @Column(name = "FROST",columnDefinition = "varchar(50) COMMENT'霜'")
    private String frost;

    @Column(name="ICE",columnDefinition = "varchar(50) COMMENT'结冰'")
    private String ice;

    @Column(name="SMOKE",columnDefinition = "varchar(50) COMMENT'烟'")
    private String smoke;

    @Column(name="HAZE",columnDefinition = "varchar(50) COMMENT'霾'")
    private String  haze;

    @Column(name="DUST" ,columnDefinition = "varchar(50) COMMENT'浮尘'")
    private String dust;

    @Column(name="DUST_TIME",columnDefinition = "datetime COMMENT'浮尘出现时间'")
    private Date dustTime;

    @Column(name="SAND_BLOWING",columnDefinition = "varchar(50) COMMENT'扬沙'")
    private String sandBlowing;

    @Column(name = "SAND_BLOWING_TIME",columnDefinition = "datetime COMMENT'扬沙出现时间'")
    private Date snadBlowingTime;


    @Column(name="DUST_DEVIL",columnDefinition = "varchar(50) COMMENT'尘卷风'")
    private String dustDevil;

    @Column(name="LIGHT_FOG",columnDefinition = "varchar(50) COMMENT'轻雾'")
    private String lightFog;

    @Column(name="LIGHTNING",columnDefinition = "varchar(50) COMMENT'闪电'")
    private String lightning;

    @Column(name="AURORA",columnDefinition = "varchar(50) COMMENT '极光'")
    private String aurora;

    @Column(name="AURORA_TIME",columnDefinition = "datetime COMMENT'极光出现时间'")
    private Date auroraTime;

    @Column(name="HIGH_WIND",columnDefinition = "varchar(50) COMMENT'大风'")
    private String highWind;


    @Column(name="HIGH_WIND_TIME",columnDefinition = "datetime COMMENT'大风出现时间'")
    private Date highWindTime;

    @Column(name="SNOW_LAY",columnDefinition = "varchar(50) COMMENT'积雪'")
    private String snowLay;

    @Column(name="THUNDER_STORM",columnDefinition = "varchar(50) COMMENT'雷暴'")
    private String thunderStorm;

    @Column(name="THUNDER_STORM_TIME",columnDefinition = "datetime COMMENT'雷暴出现时间'")
    private Date thunderStormTime;

    @Column(name="SQUALL",columnDefinition = "varchar(50) COMMENT'飑'")
    private String squall;

    @Column(name="SQUALL_TIME",columnDefinition = "datetime COMMENT'飑出现时间'")
    private Date squallTime;


    @Column(name="TORNADO",columnDefinition = "varchar(50) COMMENT'龙卷风'")
    private String tornado;

    @Column(name="TORNADO_TIME",columnDefinition = "datetime COMMENT'龙卷风出现时间'")
    private Date tornadoTime;

    @Column(name="SAND_STORM",columnDefinition = "varchar(50) COMMENT'沙尘暴'")
    private String sandStorm;

    @Column(name="SAND_STORM_TIME",columnDefinition = "datetime COMMENT'沙尘暴出现时间'")
    private Date sandStormTime;

    @Column(name="BLOWING_SNOW",columnDefinition = "varchar(50) COMMENT'吹雪'")
    private String blowingSnow;

    @Column(name="BLOWING_SNOW_TIME",columnDefinition = "datetime COMMENT'吹雪出现时间'")
    private Date blowingSnowTime;

    @Column(name="SNOW_STORM",columnDefinition = "varchar(50) COMMENT'雪暴'")
    private String snowStorm;

    @Column(name="SNOW_STORM_TIME",columnDefinition = "datetime COMMENT'雪暴'")
    private Date snowStormTime;

    @Column(name="FOG",columnDefinition = "varchar(50) COMMENT'雾'")
    private String fog;

    @Column(name="FOG_TIME",columnDefinition = "datetime COMMENT'雾出现时间'")
    private Date fogTime;

    @Column(name="RIME",columnDefinition = "varchar(50) COMMENT'雾淞'")
    private String rime;

    @Column(name="RIME_TIME",columnDefinition = "datetime COMMENT'雾淞出现时间'")
    private Date rimeTime;

    @Column(name="GLAZE",columnDefinition = "varchar(50) COMMENT'雨淞'")
    private String glaze;

    @Column(name="GLAZE_TIME",columnDefinition = "datetime COMMENT'雨淞出现时间'")
    private Date glazeTime;

    @Column(name="RAIN",columnDefinition = "varchar(50) COMMENT'雨'")
    private String rain;

    @Column(name="RAIN_TIME",columnDefinition = "datetime COMMENT'雨出现时间'")
    private Date rainTime;


    @Column(name="SNOW",columnDefinition = "varchar(50) COMMENT'雪'")
    private String snow;

    @Column(name="SNOW_TIME",columnDefinition = "datetime COMMENT'雪出现时间'")
    private Date snowTime;

    @Column(name="ICE_NEEDLE",columnDefinition = "varchar(50) COMMENT'冰针'")
    private String iceNeedle;


    @Column(name="HAIL",columnDefinition = "varchar(50) COMMENT'冰雹'")
    private String hail;

    @Column(name="HAIL_TIME",columnDefinition = "datetime COMMENT'冰雹出现时间'")
    private Date hailTime;

    @Column(name="WEATHER_SUMMARY",columnDefinition = "varchar(100) COMMENT'天气现象摘要'")
    private String weatherSummary;


    @Column(name="WEATHER_RECORD",columnDefinition = "varchar(100) COMMENT'天气现象记录'")
    private String weatherRecord;

    @Column(name="ELECTRIC_WIRE_ICE_PHENO",columnDefinition = "varchar(100) COMMENT'电线积冰-现象'")
    private String electricWireIcePheno;

    @Column(name="ELECTRIC_WIRE_S_N_DEEP",columnDefinition = "float COMMENT'电线积冰-南北方向厚度'")
    private Float electricWireSNDeep;

    @Column(name="ELECTRIC_WIRE_E_W_DEEP",columnDefinition = "float COMMENT'电线积冰-东西方向厚度'")
    private Float electricWireEWDeep;

    @Column(name="ELECTRIC_WIRE_S_N_WEIGHT",columnDefinition = "float COMMENT'电线积冰-南北方向重量'")
    private Float electricWireSNWeight;
    @Column(name="ELECTRIC_WIRE_E_W_WEIGHT",columnDefinition = "float COMMENT'电线积冰-东西方向重量'")
    private Float electricWireEWWeight;
    @Column(name="ELECTRIC_WIRE_S_N_ROUND",columnDefinition = "float COMMENT'电线积冰-南北方向直径'")
    private Float electricWireSNRound;
    @Column(name="ELECTRIC_WIRE_E_W_ROUND",columnDefinition = "float COMMENT'电线积冰-东西方向直径'")
    private Float electricWireEWRound;

    @Column(name="SOIL_FROZEN_FIRST_LAYER_UPPER",columnDefinition = "float COMMENT'第一冻土层上界值'")
    private Float soilFrozenFirstLayerUpper;

    @Column(name="SOIL_FROZEN_FIRST_LAYER_LOWER",columnDefinition = "float COMMENT'第一冻土层下界值'")
    private Float soilFrozenFirstLayerLower;

    @Column(name="SOIL_FROZEN_SECOND_LAYER_UPPER",columnDefinition = "float COMMENT'第二冻土层上界值'")
    private Float soilFrozenSecondLayerUpper;

    @Column(name="SOIL_FROZEN_SECOND_LAYER_LOWER",columnDefinition = "float COMMENT'第二冻土层下界值'")
    private Float soilFrozenSecondLayerLower;

    @Column(name = "SUN_OUT_TIME",columnDefinition = "datetime COMMENT'日出时间'")
    private Date sunOutTime;

    @Column(name = "SUN_IN_TIME",columnDefinition = "datetime COMMENT'日落时间'")
    private Date sunInTime;

    @Column(name="UPDATE_FLAG",columnDefinition = "int COMMENT'更新标志'")
    private Integer updateFlag;

}
