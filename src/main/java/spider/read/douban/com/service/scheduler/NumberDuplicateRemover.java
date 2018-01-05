package spider.read.douban.com.service.scheduler;

import common.constant.ExtractText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

/**
 * 由于
 * https://read.douban.com/ebook/21496892/?dcs=subject-buylink&dcm=douban&dct=26698660
 * https://read.douban.com/ebook/21496892/ratings 是一样的
 * 数字是唯一的
 * 而不是根据URL不同来去重复
 * @author wanzailin
 * @date 2017/12/22
 */
public class NumberDuplicateRemover extends HashSetDuplicateRemover {
    Logger logger = LoggerFactory.getLogger(NumberDuplicateRemover.class);

    /**
     * 返回独一无二的url数字
     *
     * @param request
     * @return
     */
    @Override
    public String getUrl(Request request) {
        return ExtractText.getText(request.getUrl(), ExtractText.GET_NUM_URL_REGEX);
    }
}
