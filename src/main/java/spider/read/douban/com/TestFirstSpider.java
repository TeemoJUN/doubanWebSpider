package spider.read.douban.com;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import spider.read.douban.com.service.processor.EbookPageProcessor;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import spider.read.douban.com.service.scheduler.NumberDuplicateRemover;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author wanzailin
 * @date 2017/12/11
 */
public class TestFirstSpider {
    @Test
    public void testSpider() {
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        HttpClientDownloader httpClientDownloader=new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                new Proxy("124.237.129.1",9999)
        ));
        Spider.create(new EbookPageProcessor())
                .addUrl("https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban")
                .addPipeline(new EbookPipeline())
                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new NumberDuplicateRemover()))
                .thread(5).run();
    }
}
