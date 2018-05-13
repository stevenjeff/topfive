package com.fangrui.controller;

import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangfangrui on 2018/2/25.
 */
@RestController
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @GetMapping("/ali213/{interval}")
    public Object getAli213Data(@PathVariable(name = "interval") Integer interval) throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_DATE_INTERVALS) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_DATE_INTERVAL_KEY + "_" + interval);
    }

    @GetMapping("/ali213DateRange")
    public Object getAli213DataRage() throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_DATE_INTERVALS) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_ALI213_DATE_INTERVALS);
    }

    @GetMapping("/3dm/{interval}")
    public Object get3DMData(@PathVariable(name = "interval") Integer interval) throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_DATE_INTERVALS) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_DATE_INTERVAL_KEY + "_" + interval);
    }

    @GetMapping("/3dmDateRage")
    public Object get3DMDataRage() throws Exception {
        if (HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_DATE_INTERVALS) == null) {
            spiderService.get3DMData();
        }
        return HutoolsTimedCache.timedCache.get(HutoolsTimedCache.CACHE_3DM_DATE_INTERVALS);
    }
}
