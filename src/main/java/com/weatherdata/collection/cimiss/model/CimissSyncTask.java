package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="CIMISS_SYNC_TASK")
@Entity
@Data
public class CimissSyncTask implements Serializable{

    private static final long serialVersionUID = 8991043417729186782L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID",columnDefinition = "int COMMENT'主键 自增'")
    private Integer id;
    @Column(name="TASK_NAME",columnDefinition = "varchar(50) COMMENT'任务名称'")
    private String taskName;
    @Column(name="TASK_CODE",columnDefinition = "varchar(50) COMMENT'任务编码'")
    private String taskCode;
    @Column(name="DATA_START_TIME",columnDefinition = "varchar(50) COMMENT'采集的数据的开始时间'")
    private String dataStartTime;

    @Column(name="TASK_START_TIME",columnDefinition = "varchar(50) COMMENT'任务执行时间'")
    private String taskStartTime;
    @Column(name="NEXT_DATA_TIME_INTERVAL",columnDefinition = "int COMMENT'数据采集时间间隔分钟'")
    private Integer nextDataTimeInterval;
    @Column(name="TASK_START_TIME_DELAY",columnDefinition = "int COMMENT'任务开始时间延时分钟'")
    private Integer taskStartTimeDelay;
    @Column(name="NEXT_TASK_START_TIME_INTERVAL",columnDefinition = "int COMMENT'下次采集时间间隔'")
    private Integer nextTaskStartTimeInterval;
    @Column(name="COLL_TYPE",columnDefinition = "int COMMENT'采集类型：1 站点采集 2 按地区采集'")
    private Integer collType;
    @Column(name="IS_RUN",columnDefinition = "int COMMENT'是否启动  0 不启动  1 启动'")
    private Integer isRun;
    @Column(name = "IS_RETRY",columnDefinition = "int COMMENT '是否重试 0 否 1 是'")
    private Integer isRetry;
    @Column(name = "RETRY_TIMES",columnDefinition = "int COMMENT'重试次数'")
    private Integer retryTimes;
    @Column(name="RETRY_INTERVAL",columnDefinition ="int COMMENT'重试间隔 分钟'" )
    private Integer retryInterval;

    @Column(name="DATA_TYPE",columnDefinition = "int COMMENT'数据类型： 1 分钟数据 2 小时数据 3 日数据'")
    private Integer dataType;
    @Column(name = "AREACODES",columnDefinition = "varchar(500) COMMENT'采集的行政区划代码 按区域采集时用'")
    private String areacodes;
    @Column(name = "STATION_TYPES",columnDefinition = "varchar(500) COMMENT'采集的站点类型 按站点采集时 用'")
    private String stationTypes;

}
