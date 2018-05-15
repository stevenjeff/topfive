package com.fangrui.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fangrui.bean.RowData;
import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.config.ConstVariable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/3/2
 */
public class CommonUtil {

    public static List<RowData> getTopList(List<RowData> dataList) {
        List<RowData> topList = new ArrayList<>();
        if (CollectionUtil.isEmpty(dataList)) {
            return topList;
        }
        dataList = dataList.stream().sorted().collect(Collectors.toList());
        try {
            if (dataList.size() > ConstVariable.TOP_NUM) {
                topList = dataList.subList(0, ConstVariable.TOP_NUM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topList;
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

    public static ArrayList<Integer> getDateRangeList(Date oldestDate) {
        if (oldestDate == null) {
            return null;
        }
        ArrayList dateRages = new ArrayList<Integer>();
        DateTime dateTime = DateUtil.offsetDay(oldestDate, 7);
        DateTime now = DateTime.now();
        Integer interval = 7;
        Integer temp = interval;
        do {
            dateRages.add(temp);
            temp = temp + 7;
            dateTime = DateUtil.offsetDay(dateTime, interval);
        } while (dateTime.isBeforeOrEquals(now));
        return dateRages;
    }

    public static void setRageData(List<RowData> rowDataList, ArrayList<Integer> dateRanges, String siteName) {
        if (dateRanges == null || rowDataList == null) {
            return;
        }
        DateTime now = new DateTime();
        dateRanges.stream().forEach(interval -> {
            DateTime offsetDate = DateUtil.offsetDay(now, -interval);
            List<RowData> rangeData = rowDataList.stream().filter(rowData -> {
                return rowData.getCreateDate().after(offsetDate);
            }).sorted().collect(Collectors.toList());

            HutoolsTimedCache.timedCache.put(siteName + interval, getTopList(rangeData));
        });
    }

    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            System.out.println(i);
        } while (i <= 7);
    }
}
