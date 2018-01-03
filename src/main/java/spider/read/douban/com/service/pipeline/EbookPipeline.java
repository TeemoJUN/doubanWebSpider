package spider.read.douban.com.service.pipeline;

import com.google.common.collect.Maps;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EbookPipeline implements Pipeline {


    private ConcurrentMap<Object, Object> map = Maps.newConcurrentMap();


    public void process(ResultItems resultItems, Task task) {
        //System.out.println(resultItems.get("ebookInfo"));
    }
}
