package com.fangrui.process;

import cn.hutool.core.date.DateUtil;
import com.fangrui.bean.RowData;
import com.fangrui.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/1/23
 */
public class GameAli213Forum implements PageProcessor, SpiderRunner {
    private List<RowData> rowDataList = new ArrayList<>();
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(95000);

    public static void main(String[] args) {
        GameAli213Forum gameAli213Forum = new GameAli213Forum();
        gameAli213Forum.runSpider();
    }

    @Override
    public void runSpider() {
        List<String> array = new ArrayList<>();
        for (int pageIndex = 1; pageIndex <= 10; pageIndex++) {
            array.add("http://game.ali213.net/forum-77-" + pageIndex + ".html");
        }
        String[] urls = array.toArray(new String[array.size()]);
        GameAli213Forum processor = new GameAli213Forum();
        OOSpider.create(processor).addUrl(urls).thread(5).run();
        List<RowData> rowDataList = processor.getRowDataList().stream().sorted().collect(Collectors.toList());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "ali213_" + sdf1.format(new Date());
        CommonUtil.fileLog(fileName, rowDataList);
    }

    @Override
    public void process(Page page) {
        Selectable selectable = page.getHtml().xpath("//tbody[@id~='normalthread_']");
        List<Selectable> nodes = selectable.nodes();
        if (nodes != null) {
            for (Selectable node : nodes) {
                try {
                    RowData rowData = new RowData();
                    String name = node.xpath("//th[@class='new']/a[1]/text()").toString();
                    if (StringUtils.isEmpty(name)) {
                        name = node.xpath("//th[@class='common']/a[1]/text()").toString();
                    }
                    rowData.setName(name);
                    String dateStr = node.xpath("//td[@class='by'][2]/em/span/text()").toString();
                    rowData.setCreateDate((DateUtil.parse(dateStr, "yyyy-MM-dd")));
                    rowData.setRate(node.xpath("//td[@class='num']/em/text()").toString());
                    rowData.setHref(node.xpath("//td[@class='num']/a/@href").toString());
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
