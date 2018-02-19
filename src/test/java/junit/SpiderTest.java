package junit;

import common.constant.EbookExtractText;
import common.util.RedisUtil;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import spider.read.douban.com.service.processor.EbookPageProcessor;
import spider.read.douban.com.service.scheduler.NumberDuplicateRemover;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import javax.management.JMException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wanzailin
 * @date 2017/12/23
 * 测试一些关于正则表达式的测试，看取值是不是合格
 */
public class SpiderTest {


    @Test
    public void getInteger() {
        String str = "https://read.douban.com/ebook/43125079/?icn=index-topic";
        System.out.println(EbookExtractText.getInteger(str));

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

        System.out.println("---------------------------");

        String str6="图书 / 非虚构";
        System.out.println(str6.replaceAll("\\ ","")+"   "+str6);

        String str7="〔美〕卡尔·纽波特";
        System.out.println("--"+str7.replaceAll("\\ ","")+"---"+str7);



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

        String url = getNumber(string, EbookExtractText.GET_NUM_URL_REGEX);
        System.out.println(" sdfs" + url);
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
            str = m.group(1);
            System.out.println("aaa");
        }
        return str;
    }

    @Test
    public void test() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.lpush("eBook", "wan");
        System.out.println(jedis.lpop("eBook"));
        for (int i = 0; i < 5; i++) {
            System.out.println(jedis.lpop("Book"));
        }


    }


    @Test
    public void testJedis() {
        Jedis jedis = RedisUtil.getJedis();
        //j.set("name","wanzailin");
        //System.out.println(jedis.llen("eBook"));
        assert jedis != null;
        System.out.println(jedis.lrange("eBook", 0, -1));
    }

    @Test
    public void delJedis() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.del("eBook");
    }

    @Test
    public void testSpider() throws JMException {
        // PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
//        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
//                new Proxy("124.237.129.1",9999)
//        ));
        Spider douBanEBook = Spider.create(new EbookPageProcessor())
                .addUrl("https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban")
                //.addPipeline(new EbookPipeline())
                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new NumberDuplicateRemover()))
                .thread(3);
        SpiderMonitor.instance().register(douBanEBook);
        douBanEBook.run();
    }


    @Test
    public void testDate() {
        Date date=new Date(100,10,1);

        System.out.println(date);
    }

    @Test
    public void testDouble(){
        double a=1.0;
        int b=1;
        if(a<b){
            System.out.println("AA");
        }else {
            System.out.println("BBB");
        }
    }


}
