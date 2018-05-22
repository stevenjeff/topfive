package com.fangrui.service;

import com.fangrui.domain.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/14
 */
public interface FacadeService {
    /**
     * 查询游戏键值对
     *
     * @return list
     */
    List<String> getGameKeys();

    /**
     * 查询游戏数据
     *
     * @param interval
     * @param gameSite
     * @return
     * @throws Exception
     */
    public Object getGamesData(Integer interval, String gameSite) throws Exception;

    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    Resource addResource(Resource resource);

    /**
     * 分页查询资源
     *
     * @param pageable
     * @return
     */
    Page<Resource> getResourcePage(Pageable pageable);
}
