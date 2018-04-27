package common.service;

import com.google.common.collect.Maps;
import common.dao.KeyMapper;
import common.model.param.KeyTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KeyService extends CreateTemp {
    @Resource
    private KeyMapper keyMapper;

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
        keyMapper.insertList(list);
    }

    @Override
    public String selectTemp() {
        Map<String,Object> map= Maps.newHashMap();
        map.put("dataName","关键字对比图");
        map.put("dataTitle","key");
        List<DateView> list = keyMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        }
        list = keyMapper.queryAll();
        map.put("data",list);
        return toJson.buildJson(map);
    }
}
