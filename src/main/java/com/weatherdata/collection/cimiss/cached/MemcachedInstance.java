package com.weatherdata.collection.cimiss.cached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.weatherdata.collection.cimiss.config.MemcachedConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

/**
 * 将MemcachedClient加入到IOC 中
 */
@Component
public class MemcachedInstance {

    @Autowired
    private MemcachedConfig memcachedConfig;
    @Bean
    public SockIOPool sockIOPool(){
        String[] servers =memcachedConfig.getServer();
        // 设置服务器权重
        Integer[] weights = memcachedConfig.getWeights();

        // 创建一个Socked连接池实例  获取socke连接池的实例对象
        SockIOPool pool = SockIOPool.getInstance();

        // 向连接池设置服务器和权重
        pool.setServers(servers);
        pool.setWeights(weights);

        // 设置初始连接数、最小和最大连接数以及最大处理时间
        pool.setInitConn(memcachedConfig.getInitConn());
        pool.setMinConn(memcachedConfig.getMinConn());
        pool.setMaxConn(memcachedConfig.getMaxConn());
        pool.setMaxIdle(memcachedConfig.getMaxIdle());

        // 设置主线程的睡眠时间
        pool.setMaintSleep(memcachedConfig.getMaintSleep());

        // 设置TCP的参数，连接超时等
        pool.setNagle(memcachedConfig.getNagle());
        pool.setSocketTO(memcachedConfig.getSocketTO());
        pool.setSocketConnectTO(memcachedConfig.getSocketConnectTO());

        // 初始化连接池
        pool.initialize();
        return pool;
    }


    @Bean
    public MemCachedClient memCachedClient(){
        return new MemCachedClient();
    }




}
