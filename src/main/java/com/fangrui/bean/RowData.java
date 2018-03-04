package com.fangrui.bean;

import lombok.Data;

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
