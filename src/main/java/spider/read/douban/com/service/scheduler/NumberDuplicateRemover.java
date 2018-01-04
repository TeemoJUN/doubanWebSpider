package spider.read.douban.com.service.scheduler;

import common.constant.ExtractText;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

public class NumberDuplicateRemover extends HashSetDuplicateRemover {

    public String getUrl(Request request) {
        return ExtractText.getInteger(request.getUrl()).toString();
    }
}
