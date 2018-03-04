package com.fangrui.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/3/2
 */
@Data
public class RowData implements Comparable<RowData> {
    private String name;
    private String href;
    private String rate;
    private String replyCnt;
    private String viewCnt;

    public void setName(String name) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new Exception("name is null");
        }
        this.name = name;
    }

    @Override
    public int compareTo(RowData o) {
        Integer currentRate = 0;
        Integer anotherRate = 0;
        try {
            currentRate = Integer.parseInt(this.rate);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            anotherRate = Integer.parseInt(o.rate);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return anotherRate - currentRate;
    }
}
