package com.fangrui.topfive.process;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/1/23
 */
//http://www.rarbt.com/index.php/index/index/p/
public class RarbtProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(5000);

    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        for(int pageIndex =1 ;pageIndex <=10;pageIndex ++){
            array.add("http://www.rarbt.com/index.php/index/index/p/"+pageIndex+".html");
        }
        String[] urls = array.toArray(new String[array.size()]);
        OOSpider.create(new RarbtProcessor())
                //从https://github.com/code4craft开始抓
                .addUrl(urls)
                //设置Scheduler，使用Redis来管理URL队列
                //.setScheduler(new RedisScheduler("localhost"))
                //设置Pipeline，将结果以json方式保存到文件
                .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                //开启5个线程同时执行
                .thread(5)
                //启动爬虫
                .run();
    }

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(http://www\\.rarbt\\.com/index\\.php/index/index/p/\\d+\\.html)").all());
        page.putField("author", page.getUrl().regex("http://www\\.rarbt\\.com/index\\.php/index/index/p/\\d+\\.html").toString());
        page.putField("name", page.getHtml().xpath("//div[@class='item cl']/div[@class='title']/p/a/text()").toString());
        System.out.println(page.getHtml().xpath("//div[@class='item cl']/div[@class='title']/p/a/text()").toString());
        System.out.println(page.getHtml().xpath("//div[@class='item cl']/text()").toString());
        System.out.println(page.getHtml().xpath("//div[@class='item cl']").toString());
        //        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }
}
