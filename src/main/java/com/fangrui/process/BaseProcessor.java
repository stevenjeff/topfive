package com.fangrui.process;

import cn.hutool.core.collection.CollectionUtil;
import com.fangrui.bean.RowData;
import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.config.ConstVariable;
import com.fangrui.util.CommonUtil;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/5/14
 */
public abstract class BaseProcessor implements PageProcessor, SpiderRunner {
    private List<RowData> rowDataList = new ArrayList<>();
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(95000);

    public List<RowData> getRowDataList() {
        return rowDataList;
    }

    public void setRowDataList(List<RowData> rowDataList) {
        this.rowDataList = rowDataList;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void setGamesData(List<String> array, BaseProcessor processor, String siteName) {
        String[] urls = array.toArray(new String[array.size()]);
        OOSpider.create(processor).addUrl(urls).thread(5).run();
        List<RowData> rowDataList = processor.getRowDataList().stream().sorted().collect(Collectors.toList());
        if (!CollectionUtil.isEmpty(rowDataList)) {
            Optional<RowData> rowDataOptional = rowDataList.stream().sorted(Comparator.comparing(RowData::getCreateDate)).findFirst();
            Date oldestDate = rowDataOptional.map(RowData::getCreateDate).orElse(null);
            if (oldestDate == null) {
                return;
            }
            ArrayList<Integer> dateRangeList = CommonUtil.getDateRangeList(oldestDate);
            HutoolsTimedCache.timedCache.put(siteName + ConstVariable.INTERVALS, dateRangeList);
            CommonUtil.setRageData(rowDataList, dateRangeList, siteName);
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = siteName + "_" + sdf1.format(new Date());
        CommonUtil.fileLog(fileName, rowDataList);
    }
}
