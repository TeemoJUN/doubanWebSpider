package common.service;

import com.google.common.collect.Maps;
import common.dao.KeyMapper;
import common.dao.KeyTempMapper;
import common.model.param.KeyTemp;
import common.model.param.LimitQuery;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KeyWordService extends CreateTemp {
    @Resource
    private KeyMapper keyMapper;
    @Resource
    private KeyTempMapper keyTempMapper;
    private Map<String, Integer> map;

    private Function<EbookInfo, String> function = EbookInfo::getKeyWords;

    private Consumer<String> consumer = s -> {
        String[] strings = s.split(",");
        Stream.of(strings).forEach(e -> {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        });
    };

    @Override
    void extract(int len) {
        map = Maps.newConcurrentMap();
        LimitQuery limitQuery = new LimitQuery();
        limitQuery.setEnd(SELECT_LENGTH);
        for (int i = 0; i < len; i += SELECT_LENGTH) {
            limitQuery.setStart(i);
            List<EbookInfo> list = ebookInfoMapper.selectListByNum(limitQuery);
            list.stream().map(function).filter(e-> e!=null).forEach(consumer);
        }
    }

    @Override
    void save() {
        List<KeyTemp> list = map.entrySet().stream().map(s -> {
            KeyTemp keyTemp = new KeyTemp();
            keyTemp.setKeyWords(s.getKey());
            keyTemp.setNum(s.getValue());
            return keyTemp;
        }).collect(Collectors.toList());
        keyTempMapper.insertList(list);
    }

    @Override
    public String selectTemp() {
        List<DateView> list = keyMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(list);
        }
        list = keyMapper.queryAll();

        return toJson.buildJson(list);
    }
}
