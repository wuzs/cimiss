package com.weatherdata.collection.cimiss.config;

import com.weatherdata.collection.cimiss.cached.Memcached;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将一些需要的对象加入到spring IOC 中
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public Memcached memcached(){
        return  new Memcached();
    }
}
