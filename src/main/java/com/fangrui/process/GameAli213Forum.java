package com.fangrui.process;

import cn.hutool.core.date.DateUtil;
import com.fangrui.bean.RowData;
import com.fangrui.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/1/23
 */
public class GameAli213Forum extends BaseProcessor {

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
        setGamesData(array, new GameAli213Forum(), CommonUtil.CACHE_ALI213_KEY);
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
                    this.getRowDataList().add(rowData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
