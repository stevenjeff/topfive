package com.fangrui.service;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/3
 */
public interface SpiderService {
    @Cacheable(value = "people", key = "#ali213")
    Object getAli213Data();
}
