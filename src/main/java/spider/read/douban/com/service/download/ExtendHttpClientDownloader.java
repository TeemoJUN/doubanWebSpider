package spider.read.douban.com.service.download;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

/**
 * 扩展HttpClientDownloader,可以将它处理成功的请求和失败的请求
 *
 * @author wanzailin
 * @date 2018/01/06
 */
public class ExtendHttpClientDownloader extends HttpClientDownloader{

    @Override
    protected void onSuccess(Request request) {
    }


    @Override
    protected void onError(Request request) {
    }
}
