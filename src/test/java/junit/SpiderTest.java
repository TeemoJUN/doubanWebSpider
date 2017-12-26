package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import spider.read.douban.com.TestFirstSpider;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class SpiderTest {
    @Test
    public void testSpider(){
        Spider.create(new TestFirstSpider()).addUrl("https://read.douban.com/").addPipeline(new ConsolePipeline()).thread(1).run();
    }
}
