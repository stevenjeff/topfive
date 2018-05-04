package com.fangrui.controller;

import com.fangrui.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangfangrui on 2018/2/25.
 */
@RestController
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @GetMapping("/ali213")
    public Object triggerAli213() {
        return spiderService.getAli213Data();
    }

    @GetMapping("/3dm")
    public Object trigger3DM() {
        return spiderService.get3DMData();
    }
}
