package common.service;

import com.google.common.collect.Maps;
import common.dao.RatingMapper;
import common.dao.RatingTempMapper;
import common.model.param.LimitQuery;
import common.model.param.RatingTemp;
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
@Service
public class RatingService extends CreateTemp {
    @Resource
    private RatingMapper ratingMapper;
    @Resource
    private RatingTempMapper ratingTempMapper;
    Function<EbookInfo, Double> function = EbookInfo::getRating;

    private Map<String, Integer> map;

    private Consumer<Double> consumer = e -> {
        if (e <= 1) {
            map.put("one", map.get("one") + 1);
        } else if (e <= 2) {
            map.put("two", map.get("two") + 1);
        } else if (e <= 3) {
            map.put("three", map.get("three") + 1);
        } else if (e <= 4) {
            map.put("four", map.get("four") + 1);
        } else if (e <= 5) {
            map.put("five", map.get("five") + 1);
        } else if (e <= 6) {
            map.put("six", map.get("six") + 1);
        } else if (e <= 7) {
            map.put("seven", map.get("seven") + 1);
        } else if (e <= 8) {
            map.put("eight", map.get("eight") + 1);
        } else if (e <= 9) {
            map.put("nine", map.get("nine") + 1);
        } else {
            map.put("ten", map.get("ten") + 1);
        }
    };


    @Override
    void extract(int len) {
        map = Maps.newConcurrentMap();
        map.put("one", 0);
        map.put("two", 0);
        map.put("three", 0);
        map.put("four", 0);
        map.put("five", 0);
        map.put("six", 0);
        map.put("seven", 0);
        map.put("eight", 0);
        map.put("nine", 0);
        map.put("ten", 0);
        LimitQuery limitQuery = new LimitQuery();
        limitQuery.setEnd(SELECT_LENGTH);
        for (int i = 0; i < len; i += SELECT_LENGTH) {
            limitQuery.setStart(i);
            List<EbookInfo> list = ebookInfoMapper.selectListByNum(limitQuery);
            list.stream().map(function).filter(Objects::nonNull).forEach(consumer);
        }


    }

    @Override
    void save() {
        System.out.println(map);
        List<RatingTemp> list = map.entrySet().stream().map(stringIntegerEntry -> {
            RatingTemp ratingTemp = new RatingTemp();
            ratingTemp.setRating(stringIntegerEntry.getKey());
            ratingTemp.setNum(stringIntegerEntry.getValue());
            return ratingTemp;
        }).collect(Collectors.toList());
        ratingTempMapper.insertList(list);

    }

    @Override
    String selectTemp() {
        List<DateView> list = ratingMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(list);
        }
        list = ratingMapper.queryAll();

        return toJson.buildJson(list);
    }
}
