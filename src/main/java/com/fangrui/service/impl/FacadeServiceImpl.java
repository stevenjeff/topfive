package com.fangrui.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ClassUtil;
import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.service.FacadeService;
import com.fangrui.service.SpiderService;
import com.fangrui.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/14
 */
@Service
public class FacadeServiceImpl implements FacadeService {
    @Autowired
    private SpiderService spiderService;

    @Override
    public Object getGamesData(Integer interval, String gameSite) throws Exception {
        if (interval == null || StringUtils.isEmpty(gameSite)) {
            interval = 7;
            gameSite = CommonUtil.CACHE_ALI213_KEY;
        }
        if (HutoolsTimedCache.timedCache.get(gameSite + CommonUtil.INTERVALS) == null) {
            spiderService.getAli213Data();
        }
        Method dataMethod = ClassUtil.getPublicMethod(spiderService.getClass(), "get" + StringUtils.capitalize(gameSite) + "Data");
        dataMethod.invoke(spiderService);
        HashMap<Object, Object> map = CollectionUtil.newHashMap(2);
        map.put(CommonUtil.DATA, HutoolsTimedCache.timedCache.get(gameSite + interval));
        map.put(CommonUtil.INTERVALS, HutoolsTimedCache.timedCache.get(gameSite + CommonUtil.INTERVALS));
        return map;
    }
}
