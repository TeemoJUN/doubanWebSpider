package junit;

import common.constant.ExtractText;
import org.junit.Test;
import org.junit.runner.RunWith;
import spider.read.douban.com.TestFirstSpider;
import spider.read.douban.com.service.pageProcessor.EbookPageProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class SpiderTest {
    @Test
    public void testSpider(){
        Spider.create(new EbookPageProcessor()).addUrl("https://read.douban.com/ebook/43125079/?icn=index-topic").thread(1).run();
    }
    @Test
    public void getInteger(){
        String str="https://read.douban.com/ebook/43125079/?icn=index-topic";
       System.out.println(ExtractText.getInteger(str));

       String str2="147 评价";

       System.out.println(str2.split("\\ ")[0]);
       String str3="￥7.99";
       System.out.println(str3.replace("￥",""));
       System.out.println("END");
    }
}
