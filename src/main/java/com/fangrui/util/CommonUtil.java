package com.fangrui.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/3/2
 */
public class CommonUtil {
    public static <T> String setTopList(List<T> dataList, String fileName, Integer topNum, String... propertyNames) {
        String jsonStr = null;
        try {
            if (null == topNum) {
                topNum = 10;
            }
            List<T> topList = dataList;
            if (dataList != null && dataList.size() > 10) {
                topList = dataList.subList(0, 10);
            }
            jsonStr = JSON.toJSONString(topList, getSimplePropertyPreFilter(propertyNames));
            fileLog(fileName, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static <T> String convertToJson(List<T> dataList, String fileName, String... propertyNames) {
        String jsonStr = null;
        try {
            jsonStr = JSON.toJSONString(dataList, getSimplePropertyPreFilter(propertyNames));
            fileLog(fileName, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    private static SimplePropertyPreFilter getSimplePropertyPreFilter(String[] propertyNames) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        if (propertyNames != null) {
            for (String propertyName : propertyNames) {
                filter.getIncludes().add(propertyName);
            }
        }
        return filter;
    }

    private static void fileLog(String fileName, String jsonStr) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fileName)))) {
            printWriter.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void fileLog(String fileName, List<T> dataList) {
        fileLog(fileName, JSON.toJSONString(dataList));
    }

    public static ArrayList getDateRangeList(Date oldestDate) {
        if (oldestDate == null) {
            return null;
        }
        ArrayList dateRages = null;
        DateTime dateTime = DateUtil.offsetDay(oldestDate, 7);
        DateTime now = DateTime.now();
        while (dateTime.isBeforeOrEquals(now)) {
            dateTime = DateUtil.offsetDay(dateTime, 7);
        }
        return dateRages;
    }
}
