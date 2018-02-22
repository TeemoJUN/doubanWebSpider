package common.service;

import com.google.common.collect.Maps;
import common.dao.LabelMapper;
import common.model.param.LabelTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class LabelService extends CreateTemp{
    @Resource
    private LabelMapper labelMapper;

    public LabelService(){
        super(EbookInfo::getLabel, (map,label)->{ int count = 1;
            if (map.containsKey(label)) {
                count = map.get(label) + 1;
            }
            map.put(label, count);
        });
    }

    @Override
    void save(Map<String,Integer> map) {
        List<LabelTemp> list = map.entrySet().stream().map(stringIntegerEntry -> {
            LabelTemp ratingTemp = new LabelTemp();
            ratingTemp.setLabel(stringIntegerEntry.getKey());
            ratingTemp.setNum(stringIntegerEntry.getValue());
            return ratingTemp;
        }).collect(Collectors.toList());
        labelMapper.insertList(list);
    }

    @Override
    public String selectTemp() {
        Map<String,Object> map= Maps.newHashMap();
        map.put("dataName","书籍类别对比图");
        List<DateView> list = labelMapper.queryAll();
        map.put("data",list);
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(map);
        }
        list = labelMapper.queryAll();

        return toJson.buildJson(map);
    }
}
