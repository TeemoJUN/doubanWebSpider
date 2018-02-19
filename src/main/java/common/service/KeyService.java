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
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KeyService extends CreateTemp {
    @Resource
    private KeyMapper keyMapper;
    @Resource
    private KeyTempMapper keyTempMapper;

    public KeyService(){
        super(EbookInfo::getKeyWords,(map,keyWords) -> {
            String[] keys = keyWords.split(",");
            Stream.of(keys).forEach(e -> {
                if (map.containsKey(e)) {
                    map.put(e, map.get(e) + 1);
                } else {
                    map.put(e, 1);
                }
            });
        });
    }

    @Override
    void save(Map<String,Integer> map) {
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
