package com.fangrui.schedule;

import com.fangrui.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/6
 */
@Component
public class SpiderSchedule {

    @Autowired
    private SpiderService spiderService;

    @Scheduled(fixedRate = 60000)
    public void schedule_3dm() {
        spiderService.get3dmData();
    }

    @Scheduled(fixedRate = 60000)
    public void schedule_ali213() {
        spiderService.getAli213Data();
    }
}
