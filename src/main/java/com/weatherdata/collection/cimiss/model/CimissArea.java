package com.weatherdata.collection.cimiss.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="CIMISS_AREA")
@Entity
@Data
public class CimissArea implements Serializable{
    private static final long serialVersionUID = 3017324050326049066L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID",columnDefinition = "int COMMENT '主键 自增'")
    private Integer id;

    @Column(name="AREA_NAME",length = 32,columnDefinition = " varchar(32) COMMENT '地区名称'")
    private String areaName;

    @Column(name="AREA_CODE_SIX",length = 6,columnDefinition = "varchar(6) COMMENT '6位行政区划'")
    private String areaCodeSix;


    @Column(name="AREA_CODE_TWELVE",length = 12,columnDefinition = "varchar(12) COMMENT '12位行政区划'")
    private String areaCodeTwelve;

    @Column(name="PARENT_CODE",length = 6,columnDefinition = "varchar(6) COMMENT '上级行政区划 自关联AREA_CODE_SIX'")
    private  String parentCode;

    @Column(name="AREA_TYPE",columnDefinition = "int COMMENT '区域类型  1：省  2：直辖市  3：市 4：县、区  5：乡、镇' ")
    private Integer areaType;

    @Column(name="ORDER_INDEX",columnDefinition = "int COMMENT '排序'")
    private Integer orderIndex;
}
