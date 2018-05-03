package com.fangrui.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.fangrui.process.GameAli213Forum;
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
    @Cacheable(value = "caffeineCache")
    public Object getAli213Data() {
        GameAli213Forum gameAli213Forum = new GameAli213Forum();
        String jsonStr = gameAli213Forum.runSpider();
        JSONArray parse = (JSONArray) JSONArray.parse(jsonStr);
        return parse;
    }
}
