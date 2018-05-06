package com.fangrui.service.impl;

import com.fangrui.process.GameAli213Forum;
import com.fangrui.process.RarbtProcessor;
import com.fangrui.process.ThreedmgameDay0;
import com.fangrui.service.SpiderService;
import org.springframework.stereotype.Service;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/3
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Override
    public void getAli213Data() {
        new GameAli213Forum().runSpider();
    }

    @Override
    public void get3DMData() {
        new ThreedmgameDay0().runSpider();
    }

    @Override
    public void getRarBtData() {
        new RarbtProcessor().runSpider();
    }
}
