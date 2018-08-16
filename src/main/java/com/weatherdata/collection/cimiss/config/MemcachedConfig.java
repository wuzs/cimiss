package com.weatherdata.collection.cimiss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * memcached 客户端相关的属性配置
 */
@ConfigurationProperties(prefix = "memcached")
@Configuration
@Data
public class MemcachedConfig {
    private String[] server;

    private Integer[] weights;
    private Integer initConn;
    private Integer maxConn;
    private Integer minConn;
    private Long maxIdle;
    private Long maintSleep;
    private  Boolean nagle;
    private Integer socketTO;
    private Integer  socketConnectTO;



}
