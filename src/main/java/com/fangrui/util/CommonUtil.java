package com.fangrui.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/3/2
 */
public class CommonUtil {
    public static <T> void setTopList(List<T> dataList, String fileName, Integer topNum, String... propertyNames) {
        try {
            if (null == topNum) {
                topNum = 10;
            }
            List<T> topList = dataList;
            if (dataList != null && dataList.size() > 10) {
                topList = dataList.subList(0, 10);
            }
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
            if (propertyNames != null) {
                for (String propertyName : propertyNames) {
                    filter.getIncludes().add(propertyName);
                }
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fileName)));
            printWriter.write(JSON.toJSONString(topList, filter));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
