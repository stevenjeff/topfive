package com.fangrui.controller;

import com.fangrui.domain.Resource;
import com.fangrui.service.FacadeService;
import com.fangrui.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/22
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

    @PostMapping("/resourceAdd")
    public boolean addNewResource(@RequestBody @Validated Resource resource) {
        resource.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Resource addedResource = facadeService.addResource(resource);
        if (addedResource.getId() != null) {
            return true;
        }
        return false;
    }

    @GetMapping("/resourcePage")
    public Page<Resource> getResourcePage(Pageable pageable) {
        return facadeService.getResourcePage(pageable);
    }
}
