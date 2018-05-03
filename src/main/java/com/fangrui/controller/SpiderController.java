package com.fangrui.controller;

import com.alibaba.fastjson.JSONArray;
import com.fangrui.process.GameAli213Forum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangfangrui on 2018/2/25.
 */
@RestController
public class SpiderController {

    @GetMapping("/ali213")
    public void triggerAli213() {
        GameAli213Forum gameAli213Forum = new GameAli213Forum();
        String jsonStr = gameAli213Forum.runSpider();
        JSONArray parse = (JSONArray) JSONArray.parse(jsonStr);
        System.out.println(parse);
    }
}
