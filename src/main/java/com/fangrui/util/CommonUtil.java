package com.fangrui.util;

import com.alibaba.fastjson.JSON;

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
    public static <T> void setTopTen(List<T> dataList, String fileName) {
        try {
            List<T> topList = dataList;
            if (dataList != null && dataList.size() > 10) {
                topList = dataList.subList(0, 10);
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fileName)));
            printWriter.write(JSON.toJSONString(topList));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
