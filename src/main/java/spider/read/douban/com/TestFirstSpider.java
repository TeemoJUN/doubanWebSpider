package spider.read.douban.com;

import com.google.common.collect.Maps;
import common.constant.EbookConstant;
import common.constant.ExtractText;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spider.read.douban.com.service.pageProcessor.EbookPageProcessor;
import spider.read.douban.com.service.pipeline.EbookPipeline;
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

public class TestFirstSpider{
    @Test
    public void testSpider(){
        //System.out.println(ClassLoader.getSystemResource("log4j.properties"));
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        Spider.create(new EbookPageProcessor())
                .addUrl("https://read.douban.com/ebook/21496892/?dcs=subject-buylink&dcm=douban&dct=26698660")
                .addPipeline(new EbookPipeline())
                .thread(2).run();
    }

}
