package com.fangrui.process;

import com.fangrui.bean.RowData;
import com.fangrui.util.CommonUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
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
public class RarbtProcessor implements PageProcessor, SpiderRunner {
    private List<RowData> rowDataList = new ArrayList<>();
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(95000);

    public static void main(String[] args) {
        new RarbtProcessor().runSpider();
    }

    @Override
    public void process(Page page) {
        page.putField("author", page.getUrl().regex("http://www\\.rarbt\\.com/index\\.php/index/index/p/\\d+\\.html").toString());
        page.putField("name", page.getHtml().xpath("//div[@class='item cl']/div[@class='title']/p/a/text()").toString());
        Selectable selectable = page.getHtml().xpath("//div[@class='item cl']");
        List<Selectable> nodes = selectable.nodes();
        if (nodes != null) {
            for (Selectable node : nodes) {
                try {
                    RowData rowData = new RowData();
                    rowData.setHref("http://www.rarbt.com" + node.xpath("//div[@class='title']/p[@class='tt cl']/a/@href").toString());
                    rowData.setName(node.xpath("//div[@class='title']/p[@class='tt cl']/a/@title").toString());
                    rowData.setRate(node.xpath("//div[@class='title']/p[@class='rt']/strong/text()").toString());
                    rowDataList.add(rowData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
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

    @Override
    public void runSpider() {
        List<String> array = new ArrayList<>();
        for (int pageIndex = 1; pageIndex <= 5; pageIndex++) {
            array.add("http://www.rarbt.com/index.php/index/index/p/" + pageIndex + ".html");
        }
        String[] urls = array.toArray(new String[array.size()]);
        RarbtProcessor rarbtProcessor = new RarbtProcessor();
        OOSpider.create(rarbtProcessor)
                .addUrl(urls)
                .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                .thread(5)
                .run();
        List<RowData> rowDataList = rarbtProcessor.getRowDataList().stream().sorted().collect(Collectors.toList());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "rarBt_" + sdf1.format(new Date());
        CommonUtil.fileLog(fileName, rowDataList);
    }
}
