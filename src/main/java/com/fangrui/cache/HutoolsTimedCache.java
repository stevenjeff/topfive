package com.fangrui.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/6
 */
public class HutoolsTimedCache {
    public static final String CACHE_3DM_KEY = "CACHE_3DM_KEY";
    public static final String CACHE_ALI213_KEY = "CACHE_ALI213_KEY";
    public static TimedCache<String, Object> timedCache = (TimedCache) CacheUtil.newTimedCache(60 * 60 * 1000);

    static {
        timedCache.schedulePrune(5000);
    }
}
