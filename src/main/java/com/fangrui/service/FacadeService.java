package com.fangrui.service;

import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/14
 */
public interface FacadeService {
    List<String> getGameKeys();

    public Object getGamesData(Integer interval, String gameSite) throws Exception;
}
