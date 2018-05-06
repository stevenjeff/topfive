package com.fangrui.controller;

import com.fangrui.cache.HutoolsTimedCache;
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
    public Object getAli213Data() throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_KEY) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY);
    }

    @GetMapping("/3dm")
    public Object get3DMData() throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY);
    }
}
