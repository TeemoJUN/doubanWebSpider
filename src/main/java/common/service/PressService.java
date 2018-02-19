package common.service;

import com.google.common.collect.Maps;
import common.dao.PressMapper;
import common.dao.PressTempMapper;
import common.model.param.LimitQuery;
import common.model.param.PressTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PressService extends CreateTemp {
    @Resource
    private PressTempMapper pressTempMapper;
    @Resource
    private PressMapper pressMapper;

    public PressService(){
        super(EbookInfo::getPress,(map, press) -> {
            int count = 1;
            if (map.containsKey(press)) {
                count = map.get(press) + 1;
            }
            map.put(press, count);
        });
    }




    @Override
    public void save(Map<String,Integer> map) {
        List<PressTemp> pressTemps = map.entrySet().stream().map(stringIntegerEntry -> {
            PressTemp pressTemp = new PressTemp();
            pressTemp.setPress(stringIntegerEntry.getKey());
            pressTemp.setNum(stringIntegerEntry.getValue());
            return pressTemp;
        }).collect(Collectors.toList());
        pressTempMapper.insertList(pressTemps);
        map = null;
    }

    @Override
    public String selectTemp() {
        List<DateView> list = pressMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(list);
        }
        list = pressMapper.queryAll();

        return toJson.buildJson(list);
    }


}
