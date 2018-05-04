package com.fangrui.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.fangrui.process.GameAli213Forum;
import com.fangrui.process.RarbtProcessor;
import com.fangrui.process.ThreedmgameDay0;
import com.fangrui.service.SpiderService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/3
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Override
    @Cacheable(value = "ali213Cache")
    public Object getAli213Data() {
        return JSONArray.parse(new GameAli213Forum().runSpider());
    }

    @Override
    @Cacheable(value = "3dmCache")
    public Object get3DMData() {
        return JSONArray.parse(new ThreedmgameDay0().runSpider());
    }

    @Override
    @Cacheable(value = "rarBtCache")
    public Object getRarBtData() {
        return JSONArray.parse(new RarbtProcessor().runSpider());
    }
}
