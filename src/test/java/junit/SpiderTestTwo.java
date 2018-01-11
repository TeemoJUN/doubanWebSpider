package junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;
import spider.read.douban.com.service.SavingTask;
import spider.read.douban.com.service.download.ExtendHttpClientDownloader;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

import javax.annotation.Resource;
import javax.management.JMException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class SpiderTestTwo {

    @Resource
    private EbookInfoMapper ebookInfoMapper;

    @Resource
    private ExtendHttpClientDownloader extendHttpClientDownloader;

    @Resource
    private PageProcessor pageProcessor;

    @Resource
    private HashSetDuplicateRemover hashSetDuplicateRemover;

    @Test
    public void testSpider() throws JMException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);

        BlockingDeque<EbookInfo> blockingDeque=new LinkedBlockingDeque<EbookInfo>();
        EbookPipeline ebookPipeline=new EbookPipeline(blockingDeque);

        SavingTask savingTask=new SavingTask(blockingDeque);
        savingTask.setEbookInfoMapper(ebookInfoMapper);

        Spider spider=Spider.create(pageProcessor)
                .addPipeline(ebookPipeline)
                .setDownloader(extendHttpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(hashSetDuplicateRemover))
                .addUrl("https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban")
                .setExecutorService(executorService)
                .thread(3);
        SpiderMonitor.instance().register(spider);
        executorService.execute(savingTask);
        spider.run();
    }

}
