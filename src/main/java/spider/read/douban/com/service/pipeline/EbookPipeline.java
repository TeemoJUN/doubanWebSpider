package spider.read.douban.com.service.pipeline;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.concurrent.ConcurrentMap;

/**
 * @author wanzailin
 * @date 2017/12/22
 */
public class EbookPipeline implements Pipeline {
    Logger logger = LoggerFactory.getLogger(EbookPipeline.class);

    private ConcurrentMap<Object, Object> map = Maps.newConcurrentMap();



    public void process(ResultItems resultItems, Task task) {
        //logger.info("搜到 {}",resultItems.get("ebookInfo"));
    }
}
