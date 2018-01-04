package spider.read.douban.com.service.pipeline;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spider.read.douban.com.service.pageProcessor.EbookPageProcessor;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EbookPipeline implements Pipeline {
    Logger logger = LoggerFactory.getLogger(EbookPipeline.class);

    private ConcurrentMap<Object, Object> map = Maps.newConcurrentMap();


    public void process(ResultItems resultItems, Task task) {
        //logger.info("搜到 {}",resultItems.get("ebookInfo"));
    }
}
