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
    public Object triggerAli213() {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_KEY) == null) {
            HutoolsTimedCache.timedCache.put(HutoolsTimedCache.CACHE_ALI213_KEY, spiderService.get3DMData());
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY);
    }

    @GetMapping("/3dm")
    public Object trigger3DM() {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY) == null) {
            HutoolsTimedCache.timedCache.put(HutoolsTimedCache.CACHE_3DM_KEY, spiderService.get3DMData());
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_KEY);
    }
}
