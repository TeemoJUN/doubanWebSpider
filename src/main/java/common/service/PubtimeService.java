package common.service;

import common.dao.PubtimeMapper;
import common.dao.PubtimeTempMapper;
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
    @Resource
    private PubtimeTempMapper pubtimeTempMapper;

    public PubtimeService() {
        super(ebookInfo -> {
            LocalDate localDate = ebookInfo.getPubtime();
            if(localDate!=null){
                StringBuilder sb=new StringBuilder();
                sb.append(localDate.getYear());
                sb.append("-");
                if(localDate.getMonthValue()<10){
                    sb.append("0");
                    sb.append(localDate.getMonthValue());
                }else{
                    sb.append(localDate.getMonthValue());
                }
                return sb.toString();
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
        pubtimeTempMapper.insertList(list);
    }

    @Override
    String selectTemp() {
        List<DateView> list = pubtimeMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(list);
        }
        list = pubtimeMapper.queryAll();
        return toJson.buildJson(list);
    }
}
