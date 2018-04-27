package common.service;

import com.google.common.collect.Maps;
import common.dao.RatingMapper;
import common.model.param.LimitQuery;
import common.model.param.RatingTemp;
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
public class RatingService extends CreateTemp {
    @Resource
    private RatingMapper ratingMapper;

    private Function<EbookInfo, Double> function = EbookInfo::getRating;

    private BiConsumer<Map<String, Integer>,Double> consumer = (map, rating) -> {
        if (rating <= 2.0) {
            map.put("1.0～2.0", map.get("1.0～2.0") + 1);
        } else if (rating <= 3.0) {
            map.put("2.0~3.0", map.get("2.0~3.0") + 1);
        } else if (rating <= 4.0) {
            map.put("3.0~4.0", map.get("3.0~4.0") + 1);
        } else if (rating <= 5.0) {
            map.put("4.0~5.0", map.get("4.0~5.0") + 1);
        } else if (rating <= 6.0) {
            map.put("5.0~6.0", map.get("5.0~6.0") + 1);
        } else if (rating <= 7.0) {
            map.put("6.0~7.0", map.get("6.0~7.0") + 1);
        } else if (rating <= 8.0) {
            map.put("7.0~8.0", map.get("7.0~8.0") + 1);
        } else if (rating <= 9.0) {
            map.put("8.0~9.0", map.get("8.0~9.0") + 1);
        } else {
            map.put("9.0~10.0", map.get("9.0~10.0") + 1);
        }
    };


    @Override
    protected Map<String,Integer> extract(int len) {
        Map<String, Integer> map = Maps.newConcurrentMap();
        map.put("1.0～2.0", 0);
        map.put("2.0~3.0", 0);
        map.put("3.0~4.0", 0);
        map.put("4.0~5.0", 0);
        map.put("5.0~6.0", 0);
        map.put("6.0~7.0", 0);
        map.put("7.0~8.0", 0);
        map.put("8.0~9.0", 0);
        map.put("9.0~10.0", 0);
        LimitQuery limitQuery = new LimitQuery();
        limitQuery.setEnd(SELECT_LENGTH);
        for (int i = 0; i < len; i += SELECT_LENGTH) {
            limitQuery.setStart(i);
            List<EbookInfo> list = ebookInfoMapper.selectListByNum(limitQuery);
            list.stream().map(function).filter(Objects::nonNull).forEach(rating->{
                consumer.accept(map,rating);
            });
        }
        return map;
    }

    @Override
    void save(Map<String,Integer> map) {
        List<RatingTemp> list = map.entrySet().stream().map(stringIntegerEntry -> {
            RatingTemp ratingTemp = new RatingTemp();
            ratingTemp.setRating(stringIntegerEntry.getKey());
            ratingTemp.setNum(stringIntegerEntry.getValue());
            return ratingTemp;
        }).collect(Collectors.toList());
        ratingMapper.insertList(list);

    }

    @Override
    public String selectTemp() {
        Map<String,Object> map=Maps.newHashMap();
        map.put("dataName","评分分布");
        map.put("dataTitle","rating");
        List<DateView> list = ratingMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
            list = ratingMapper.queryAll();
        }
        map.put("data",list);
        return toJson.buildJson(map);
    }
}
