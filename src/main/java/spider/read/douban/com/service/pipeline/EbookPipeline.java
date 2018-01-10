package spider.read.douban.com.service.pipeline;

import com.google.common.collect.Maps;
import common.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wanzailin
 * @date 2017/12/22
 */
@Service
public class EbookPipeline implements Pipeline {

    //Logger logger = LoggerFactory.getLogger(EbookPipeline.class);

   // private ConcurrentMap<Object, Object> map = Maps.newConcurrentMap();

    @Resource
    private EbookInfoMapper ebookInfoMapper;

    public void process(ResultItems resultItems, Task task) {
        //logger.info("搜到 {}",resultItems.get("ebookInfo"));
        //jedis.lpush("eBook",resultItems.get("ebookInfo").toString());
        // System.out.println(resultItems.get("ebookInfo").toString());
        EbookInfo ebookInfo = (EbookInfo) resultItems.get("ebookInfo");
        ebookInfoMapper.insertSelective(ebookInfo);

    }
}
