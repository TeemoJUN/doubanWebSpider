package junit;

import common.constant.ExtractText;
import org.junit.Test;
import spider.read.douban.com.service.processor.EbookPageProcessor;
import us.codecraft.webmagic.Spider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderTest {
    @Test
    public void testSpider() {
        Spider.create(new EbookPageProcessor()).addUrl("https://read.douban.com/ebook/43125079/?icn=index-topic")
                .thread(1).run();
    }

    @Test
    public void getInteger() {
        String str = "https://read.douban.com/ebook/43125079/?icn=index-topic";
        System.out.println(ExtractText.getInteger(str));

        String str2 = "147 评价";

        System.out.println(str2.split("\\ ")[0]);
        String str3 = "￥7.99";
        System.out.println(str3.replace("￥", ""));

        String str4 = "约 125,000 字";
        System.out.println(str4.replaceAll(",", ""));

        str4 = str4.replaceAll(",", "");

        Pattern pattern = Pattern.compile("\\ (\\d+)\\ ");

        Matcher find = pattern.matcher(str4);

        while (find.find()) {
            System.out.println(find.group(1));
        }

        String str5 = "<meta itemprop=\"keywords\" content=\"情感,悬疑,爱情小说,都市小说,限时特价\">";

        pattern = Pattern.compile("content=\"(.*)\"");
        find = pattern.matcher(str5);
        while (find.find()) {
            System.out.println("zi " + find.group(1));
        }

        System.out.println("END");


    }

    @Test
    public void testSon() {
        Son s = new Son();
        s.addList();
        s.sayA();
        s.addList();
        s.addList();
        System.out.println(s.getSize());
    }

    @Test
    public void testUrl() {
        String string = "https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban";

        String url=getNumber(string, ExtractText.GET_NUM_URL_REGEX);
        System.out.println(" sdfs"+url);
    }


    public static String getNumber(String str, String regex) {
        if (str == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern);
        Matcher m = pattern.matcher(str);
        System.out.println(m);

        while (m.find()) {
            str=m.group(1);
            System.out.println("aaa");
        }
        return str;
    }

    @Test
    public void test(){
        while(true){

        }
    }











}
