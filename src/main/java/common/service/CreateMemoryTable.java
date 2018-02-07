package common.service;

import com.google.common.collect.Maps;
import common.dao.PressMapper;
import common.dao.PressTempMapper;
import common.model.param.LimitQuery;
import common.model.param.PressTemp;
import common.model.vo.MaxAndMin;
import common.model.vo.PressView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * 临时表的创建
 *
 * @author wanzailin
 * @date 2018/02/02
 */
@Service
public class CreateMemoryTable {
    private final static int SELECT_LENGTH = 2000;
    private static volatile Boolean flag = true;
    @Resource
    private EbookInfoMapper ebookInfoMapper;
    @Resource
    private PressTempMapper pressTempMapper;
    @Resource
    private PressMapper pressMapper;

    @Autowired
    private ToJson toJson;

    private ReentrantLock lock = new ReentrantLock(true);

    Map<String, Integer> map;

    private MaxAndMin selectMaxMin() {
        return ebookInfoMapper.queryMinMax();
    }

    public void createPressTemp() {
        lock.lock();
        if (!flag) {
            lock.unlock();
            return;
        }
        MaxAndMin maxAndMin = selectMaxMin();
        int lo = maxAndMin.getMin();
        int hi = maxAndMin.getMin();
        map = Maps.newConcurrentMap();
        for (int i = lo; i <= hi + SELECT_LENGTH; i += SELECT_LENGTH) {
            int height = i + SELECT_LENGTH - 1;
            if (height > hi) {
                height = hi;
            }
            LimitQuery limitQuery = new LimitQuery();
            limitQuery.setStart(i);
            limitQuery.setEnd(height);
            List<EbookInfo> list = ebookInfoMapper.selectListByNum(limitQuery);

            list.stream().parallel().map(ebookInfo -> ebookInfo.getPress()).filter(press -> press != null).forEach
                    (press -> {
                        int count = 1;
                        if (map.containsKey(press)) {
                            count = map.get(press) + 1;
                        }
                        map.put(press, count);
                    });
        }
        save();
        flag = false;
        lock.unlock();
    }

    private void save() {
        List<PressTemp> pressTemps = map.entrySet().stream().map(stringIntegerEntry -> {
            PressTemp pressTemp = new PressTemp();
            pressTemp.setPress(stringIntegerEntry.getKey());
            pressTemp.setNum(stringIntegerEntry.getValue());
            return pressTemp;
        }).collect(Collectors.toList());
        pressTempMapper.insertList(pressTemps);
        map = null;
    }

    public String selectPressTemp() {
        if (flag) {
            createPressTemp();
        }
        List<PressView> list =pressMapper.queryAll();

        return toJson.buildJson(list);
    }


}
