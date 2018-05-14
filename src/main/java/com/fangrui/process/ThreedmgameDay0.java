package com.fangrui.process;

import cn.hutool.core.date.DateUtil;
import com.fangrui.bean.RowData;
import com.fangrui.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangfangrui
 * @description
 * @date 2018/1/23
 */
public class ThreedmgameDay0 extends BaseProcessor {

    @Override
    public void runSpider() {
        List<String> array = new ArrayList<>();
        array.add("http://bbs.3dmgame.com/game0day");
        for (int pageIndex = 2; pageIndex <= 10; pageIndex++) {
            array.add("http://bbs.3dmgame.com/forum-game0day-" + pageIndex + ".html");
        }
        setGamesData(array, new ThreedmgameDay0(), CommonUtil.CACHE_3DM_KEY);
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
                    this.getRowDataList().add(rowData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
