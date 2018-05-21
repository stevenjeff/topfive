package com.fangrui.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ClassUtil;
import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.config.ConstVariable;
import com.fangrui.repository.ResourceRepository;
import com.fangrui.service.FacadeService;
import com.fangrui.service.SpiderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/14
 */
@Service
public class FacadeServiceImpl implements FacadeService {
    @Autowired
    private SpiderService spiderService;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<String> getGameKeys() {
        return Arrays.asList(ConstVariable.GAME_KEYS);
    }

    @Override
    public Object getGamesData(Integer interval, String gameSite) throws Exception {
        if (interval == null || StringUtils.isEmpty(gameSite)) {
            interval = 7;
            gameSite = ConstVariable.CACHE_ALI213_KEY;
        }
        if (HutoolsTimedCache.timedCache.get(gameSite + ConstVariable.INTERVALS) == null) {
            Method dataMethod = ClassUtil.getPublicMethod(spiderService.getClass(), "get" + StringUtils.capitalize(gameSite) + "Data");
            dataMethod.invoke(spiderService);
        }
        HashMap<Object, Object> map = CollectionUtil.newHashMap(2);
        map.put(ConstVariable.DATA, HutoolsTimedCache.timedCache.get(gameSite + interval));
        map.put(ConstVariable.INTERVALS, HutoolsTimedCache.timedCache.get(gameSite + ConstVariable.INTERVALS));
        return map;
    }
}
