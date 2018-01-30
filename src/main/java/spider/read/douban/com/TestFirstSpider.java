package spider.read.douban.com;

import org.apache.log4j.PropertyConfigurator;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import spider.read.douban.com.service.processor.EbookPageProcessor;
import spider.read.douban.com.service.scheduler.NumberDuplicateRemover;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import javax.management.JMException;

/**
 * @author wanzailin
 * @date 2017/12/11
 */
public class TestFirstSpider {
/*
    public void testSpider() throws JMException {
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        HttpClientDownloader httpClientDownloader=new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                new Proxy("124.237.129.1",9999)
        ));
        Spider douBanEBook=Spider.create(new EbookPageProcessor())
                .addUrl("https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban")
                .addPipeline(new EbookPipeline())
                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new NumberDuplicateRemover()))
                .thread(3);
        SpiderMonitor.instance().register(douBanEBook);
        douBanEBook.run();
    }
    */ 
}
