package spider.read.douban.com.service.scheduler;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;

public class NoRepeatScheduler extends DuplicateRemovedScheduler {

    public Request poll(Task task) {
        return null;
    }
}
