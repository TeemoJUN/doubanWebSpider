package spider.read.douban.com;

import com.google.common.collect.Maps;
import common.constant.EbookConstant;
import common.constant.ExtractText;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFirstSpider implements PageProcessor {
    Logger logger = LoggerFactory.getLogger(TestFirstSpider.class);


    private ConcurrentMap<Object, Object> map = Maps.newConcurrentMap();
    public void process(Page page) {
       // int i = 0;
        //int j = 0;
        //List<String> targetList=new ArrayList<String>();
        Html html=page.getHtml();
        for (Selectable selectable : html.links().nodes()) {
            //j++;
            System.out.println("Link:" + selectable.toString());
            //logger.info("Link : {}",selectable.get());
        }
//        System.out.println("该页面总计有"+j+"条链接");
//        for(Selectable selectable:page.getHtml().links().nodes()) {
//            //System.out.println("获取：" + selectable.regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString());
//           if(selectable.regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString()!=null){
//               i++;
//               targetList.add(selectable.toString());
//           }
//        }



//        Selectable title = html.xpath(EbookConstant.TITLE_XPATH);
//        Selectable translator=html.xpath(EbookConstant.TRANSLATOR_XPATH);
//        //System.out.println(translator.get());
//        String user= ExtractText.getText(translator.get(),ExtractText.GET_A_TEXT_REGEX);
//
//        System.out.println(user);
//
//        System.out.println(ExtractText.getText(html.xpath(EbookConstant.DESCRIPTION_XPATH).get(),ExtractText.GET_P_TEXT_REGEX));
//        System.out.println(html.xpath(EbookConstant.TITLE_XPATH).get());
//        System.out.println(html.xpath(EbookConstant.POPULAR_ANNOTATIONS_XPATH).get());
//        System.out.println(html.xpath(EbookConstant.PRESS_XPATH).get());
//        System.out.println(html.xpath(EbookConstant.SUBTITLE_XPATH).get());
        System.out.println(html.xpath(EbookConstant.TRANSLATOR_XPATH));
        System.out.println(html.xpath(EbookConstant.DESCRIPTION_XPATH));
        System.out.println(html.xpath("/html/body/div/div[2]/article/div[3]/div[2]/div[2]/ol"));



        //Selectable subtitle=html.xpath();
        //Selectable authorName=html.xpath();

        //System.out.println(title.get());
        //System.out.println(translator);

        //page.addTargetRequest(page.getHtml().links().regex("https://read\\.douban\\.com/ebook/\\d+/\\?icn=index-indie-rec").toString());
        // System.out.println("获取总计：" +i+"条链接");
        //page.addTargetRequests(targetList);
        page.addTargetRequests(html.links().regex("https://read\\.douban\\.com/ebook/\\d+/.*").all());


    }

    private Site site = Site.me();

    public Site getSite() {
        return site;
    }

//    public static void main(String[] args) {
//        // System.out.print("AAAAA"+"////");
//        Spider.create(new TestFirstSpider()).addUrl("https://read.douban.com/").addPipeline(new ConsolePipeline()).thread(1).run();
//        //  String s="https://read.douban.com/ebook/30390689/?icn=index-rec";
//        //Pattern pattern=Pattern.compile("\\d+");
//        // Matcher a=pattern.matcher(s);
//        //System.out.println(a.groupCount());
//        // System.out.println(a.group(0));
//        //      while(a.find()){
//        //        System.out.println(a.group());
//        //  }
//
//    }

    @Test
    public void testSpider(){
        Spider.create(new TestFirstSpider()).addUrl("https://read.douban.com/ebook/30390689/?icn=index-rec").addPipeline(new ConsolePipeline()).thread(1).run();

//        /[\\d+]/
//        String  str = "<a href=\",5094.1\">weblogic日志编码大全</a>";
//        Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>");
//        Matcher m = p.matcher(str);
//        while(m.find()) {
//            //System.out.println("qq");
//            System.out.println(m.group());
//        }
//
//        String str2="<span class=\"labeled-text\"><a class=\"author-item\" href=\"/search?q=%E5%BC%A0%E6%99%93%E6%9E%97\">张晓林</a><a class=\"author-item\" href=\"/search?q=%E4%B9%94%E9%9B%81\">乔雁</a></span>\n";
//        Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>");
//        Matcher m=p.matcher(str2);
//        while(m.find()){
//            System.out.println(m.group(1));
//        }
        //   "<p[^>]*>([^<]*)</p>"


//        String str="https://read.douban.com/ebook/30390689/?icn=index-rec";
//
//        Pattern p=Pattern.compile("/(\\d+)");
//
//        Matcher m=p.matcher(str);
//        //System.out.println(m.find());
//        while(m.find()){
//            System.out.println(m.group(1));
//        }
    }

}
