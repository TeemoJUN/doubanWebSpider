package spider.read.douban.com.service.download;

import common.util.RedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
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

    @Override
    protected void onSuccess(Request request) {

        String successUrl=request.getUrl();

        RedisUtil.getJedis().lpush("successUrl",successUrl);

    }


    @Override
    protected void onError(Request request) {
        String errorUrl=request.getUrl();
        RedisUtil.getJedis().lpush("errorUrl",errorUrl);
    }
}
