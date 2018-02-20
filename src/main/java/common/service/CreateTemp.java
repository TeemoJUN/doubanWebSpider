package common.service;

import com.google.common.collect.Maps;
import common.model.param.LimitQuery;
import common.model.vo.MaxAndMin;
import org.springframework.beans.factory.annotation.Autowired;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 临时表的创建
 *
 * @author wanzailin
 * @date 2018/02/02
 */

public abstract class CreateTemp {

    final static int SELECT_LENGTH = 2000;

    private volatile Boolean flag = true;
    @Resource
    EbookInfoMapper ebookInfoMapper;
    @Autowired
    protected ToJson toJson;
    private ReentrantLock lock = new ReentrantLock(true);

    private Function<EbookInfo, String> function;

    private BiConsumer<Map<String, Integer>, String> consumer;

    public CreateTemp() { }

    public CreateTemp(Function<EbookInfo, String> function, BiConsumer<Map<String, Integer>, String> consumer) {
        this.consumer = consumer;
        this.function = function;
    }

    void createTempTable() {
        lock.lock();
        if (!flag) {
            lock.unlock();
            return;
        }

        int len = getTotalLength();

        Map<String, Integer> map = extract(len);

        save(map);

        flag = false;
        lock.unlock();
    }

    private int getTotalLength() {
        MaxAndMin maxAndMin = selectMaxMin();
        int hi = maxAndMin.getMax() - maxAndMin.getMin() + 1;
        return hi % SELECT_LENGTH == 0 ? hi : (hi / SELECT_LENGTH + 1) * SELECT_LENGTH;
    }


    protected Map<String, Integer> extract(int len) {
        Map<String, Integer> map = Maps.newConcurrentMap();
        LimitQuery limitQuery = new LimitQuery();
        limitQuery.setEnd(SELECT_LENGTH);
        for (int i = 0; i < len; i += SELECT_LENGTH) {
            limitQuery.setStart(i);
            List<EbookInfo> list = ebookInfoMapper.selectListByNum(limitQuery);
            list.stream().map(function).filter(Objects::nonNull).forEach(s -> {
                consumer.accept(map, s);
            });
        }
        return map;
    }
    private MaxAndMin selectMaxMin() {
        return ebookInfoMapper.queryMinMax();
    }

    abstract void save(Map<String, Integer> map);

    abstract String selectTemp();

}
