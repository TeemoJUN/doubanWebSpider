package sprider.read.douban.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

public class TestFirstSpider implements PageProcessor {
    Logger logger= LoggerFactory.getLogger(TestFirstSpider.class);
    public void process(Page page) {
        int i=0;int j=0;
        List<String> targetList=new ArrayList<String>();
        for (Selectable selectable:page.getHtml().links().nodes()){
        j++;
            System.out.println("Link:"+selectable.toString());
        }
        System.out.println("该页面总计有"+j+"条链接");
        for(Selectable selectable:page.getHtml().links().nodes()) {
            System.out.println("获取：" + selectable.regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString());
           if(selectable.regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString()!=null){
               i++;
               targetList.add(selectable.toString());
           }
        }
        //page.addTargetRequest(page.getHtml().links().regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString());
        System.out.println("获取总计：" +i+"条链接");
        page.addTargetRequests(targetList);
    }
    private Site site=Site.me();
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
       // System.out.print("AAAAA"+"////");
        Spider.create(new TestFirstSpider()).addUrl("https://read.douban.com/").thread(1).run();
    }
}
