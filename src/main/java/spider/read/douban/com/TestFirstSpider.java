package spider.read.douban.com;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import spider.read.douban.com.service.processor.EbookPageProcessor;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import spider.read.douban.com.service.scheduler.NumberDuplicateRemover;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author wanzailin
 * @date 2017/12/11
 */
public class TestFirstSpider {
    @Test
    public void testSpider() {
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        Spider.create(new EbookPageProcessor())
                .addUrl("https://read.douban.com/ebook/21496892")
                .addPipeline(new EbookPipeline())
                .setScheduler(new QueueScheduler().setDuplicateRemover(new NumberDuplicateRemover()))
                .thread(2).run();
    }
}
