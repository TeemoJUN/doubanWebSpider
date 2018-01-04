package junit;

import common.constant.ExtractText;
import org.junit.Test;
import org.junit.runner.RunWith;
import spider.read.douban.com.TestFirstSpider;
import spider.read.douban.com.service.pageProcessor.EbookPageProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

       String str4="约 125,000 字";
       System.out.println(str4.replaceAll(",",""));

       str4=str4.replaceAll(",","");

        Pattern pattern=Pattern.compile("\\ (\\d+)\\ ");

        Matcher find=pattern.matcher(str4);

        while(find.find()){
            System.out.println(find.group(1));
        }

        String str5="<meta itemprop=\"keywords\" content=\"情感,悬疑,爱情小说,都市小说,限时特价\">";

        pattern=Pattern.compile("content=\"(.*)\"");
        find=pattern.matcher(str5);
        while(find.find()){
            System.out.println("zi "+find.group(1));
        }

       System.out.println("END");


    }

    @Test
    public void testSon(){
        Son s=new Son();
        s.addList();
        s.sayA();
        s.addList();
        s.addList();
        System.out.println(s.getSize());
    }

}
