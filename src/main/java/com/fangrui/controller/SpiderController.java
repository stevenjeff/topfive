package com.fangrui.controller;

import com.fangrui.service.FacadeService;
import com.fangrui.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangfangrui on 2018/2/25.
 */
@RestController
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @Autowired
    private FacadeService facadeService;

    @GetMapping("/games/keys")
    public List<String> getGamesKey() throws Exception {
        return facadeService.getGameKeys();
    }

    @GetMapping("/games/{gameSite}/{interval}")
    public Object getGamesData(@PathVariable(name = "interval") Integer interval, @PathVariable(name = "gameSite") String gameSite) throws Exception {
        return facadeService.getGamesData(interval, gameSite);
    }

}
