package common.service;

import com.google.common.collect.Maps;
import common.dao.PubtimeMapper;
import common.model.param.PubtimeTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class PubtimeService extends CreateTemp {

    @Resource
    private PubtimeMapper pubtimeMapper;

    public PubtimeService() {
        super(ebookInfo -> {
            LocalDate localDate = ebookInfo.getPubtime();
            if(localDate!=null){
                return String.valueOf(localDate.getYear());
            }
            return null;
        }, (map, localDate) -> {
            if (map.containsKey(localDate)) {
                map.put(localDate, map.get(localDate) + 1);
            } else {
                map.put(localDate, 1);
            }
        });
    }

    @Override
    void save(Map<String, Integer> map) {
        List<PubtimeTemp> list = map.entrySet().stream().map(s -> {
            PubtimeTemp pubtimeTemp = new PubtimeTemp();
            pubtimeTemp.setPubtime(s.getKey());
            pubtimeTemp.setNum(s.getValue());
            return pubtimeTemp;
        }).collect(Collectors.toList());
        pubtimeMapper.insertList(list);
    }

    @Override
    String selectTemp() {
        Map<String,Object> map= Maps.newHashMap();
        map.put("dataName","出版时间对比图");
        List<DateView> list = pubtimeMapper.queryAll();
        map.put("data",list);
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(map);
        }
        list = pubtimeMapper.queryAll();
        return toJson.buildJson(map);
    }
}
