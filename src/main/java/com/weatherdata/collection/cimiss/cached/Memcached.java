package com.weatherdata.collection.cimiss.cached;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * memcached  操作的相关公共方法
 */
public class Memcached {
    @Autowired
    private MemCachedClient mcc;

    /**
     * 将数据放置缓存
     * @param key
     * @param data
     * @return
     */
    public boolean setString(String key,Object data){
       return  mcc.set(key,data);
    }

    /**
     * 从缓存中获取数据
     * @param key
     * @return
     */
    public Object getString(String key){
        return mcc.get(key);
    }
}
