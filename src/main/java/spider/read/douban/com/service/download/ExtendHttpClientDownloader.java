package spider.read.douban.com.service.download;

import common.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import spider.read.douban.com.service.pipeline.EbookPipeline;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

/**
 * 扩展HttpClientDownloader,可以将它处理成功的请求和失败的请求
 *
 * @author wanzailin
 * @date 2018/01/06
 */
@Service
public class ExtendHttpClientDownloader extends HttpClientDownloader{
    Logger logger = LoggerFactory.getLogger(ExtendHttpClientDownloader.class);
    private Object object=new Object();

    @Override
    public void onSuccess(Request request) {
        Jedis jedis=RedisUtil.getJedis();
       synchronized (object){
           try{
               String successUrl=request.getUrl();
               jedis.lpush("successUrl",successUrl);
           }finally {
               RedisUtil.returnResource(jedis);
           }
       }

    }

    @Override
    public void onError(Request request) {
        Jedis jedis=RedisUtil.getJedis();
        synchronized (object){
            try{
                String errorUrl=request.getUrl();
                jedis.lpush("errorUrl",errorUrl);
            }finally {
                RedisUtil.returnResource(jedis);
            }
        }
    }

}
