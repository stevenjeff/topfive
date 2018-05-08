package com.fangrui.process;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.fangrui.bean.RowData;
import com.fangrui.cache.HutoolsTimedCache;
import com.fangrui.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.*;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/1/23
 */
public class ThreedmgameDay0 implements PageProcessor, SpiderRunner {
    private List<RowData> rowDataList = new ArrayList<>();
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(95000);

    @Override
    public void runSpider() {
        List<String> array = new ArrayList<>();
        array.add("http://bbs.3dmgame.com/game0day");
        for (int pageIndex = 2; pageIndex <= 10; pageIndex++) {
            array.add("http://bbs.3dmgame.com/forum-game0day-" + pageIndex + ".html");
        }
        String[] urls = array.toArray(new String[array.size()]);
        ThreedmgameDay0 processor = new ThreedmgameDay0();
        OOSpider.create(processor).addUrl(urls).thread(5).run();
        List<RowData> rowDataList = processor.getRowDataList();
        if (!CollectionUtil.isEmpty(rowDataList)) {
            Optional<RowData> rowDataOptional = rowDataList.stream().sorted(Comparator.comparing(RowData::getCreateDate)).findFirst();
            Date oldestDate = rowDataOptional.map(RowData::getCreateDate).orElse(null);
            if (oldestDate == null) {
                return;
            }
            ArrayList<Integer> dateRangeList = CommonUtil.getDateRangeList(oldestDate);
            HutoolsTimedCache.timedCache.put(HutoolsTimedCache.CACHE_3DM_DATE_INTERVALS, dateRangeList);
        }
        String fileName = "3dmDay0_" + DateUtil.format(new Date(), "yyyy-MM-dd");
        CommonUtil.fileLog(fileName, rowDataList);
    }

    public static void main(String[] args) throws Exception {
        long betweenDay = DateUtil.betweenDay(DateUtil.parse("2018-5-5", "yyyy-MM-dd"), new Date(), true);
        System.out.println(betweenDay);
//        new ThreedmgameDay0().runSpider();
    }

    @Override
    public void process(Page page) {
        Selectable selectable = page.getHtml().xpath("//tbody[@id~='normalthread_']");
        List<Selectable> nodes = selectable.nodes();
        if (nodes != null) {
            for (Selectable node : nodes) {
                try {
                    RowData rowData = new RowData();
                    String name = node.xpath("//th[@class='new']/a[3]/text()").toString();
                    if (StringUtils.isEmpty(name)) {
                        name = node.xpath("//th[@class='common']/a[3]/text()").toString();
                    }
                    rowData.setName(name);
                    rowData.setRate(node.xpath("//td[@class='num']/em/text()").toString());
                    String  dateStr = node.xpath("//td[@class='by']/em/a/text()").toString();
                    rowData.setCreateDate((DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm")));
                    rowData.setHref("http://bbs.3dmgame.com/" + node.xpath("//td[@class='num']/a/@href").toString());
                    rowDataList.add(rowData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
}
