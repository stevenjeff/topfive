package com.fangrui.bean;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/3/2
 */
public class RowData implements Comparable<RowData> {
    private String name;
    private String href;
    private String rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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
