package common.service;

import com.google.common.collect.Maps;
import common.dao.ProviderMapper;
import common.dao.ProviderTempMapper;
import common.model.param.LimitQuery;
import common.model.param.ProviderTemp;
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
public class ProviderService extends CreateTemp {

    @Resource
    private ProviderTempMapper providerTempMapper;
    @Resource
    private ProviderMapper providerMapper;

    public ProviderService(){
        super(EbookInfo::getProvider,(map,provider) -> {
            int count = 1;
            if (map.containsKey(provider)) {
                count = map.get(provider) + 1;
            }
            map.put(provider, count);
        });
    }


    @Override
    void save(Map<String,Integer> map) {
        List<ProviderTemp> providerTemps = map.entrySet().stream().map(stringIntegerEntry -> {
            ProviderTemp providerTemp = new ProviderTemp();
            providerTemp.setProvider(stringIntegerEntry.getKey());
            providerTemp.setNum(stringIntegerEntry.getValue());
            return providerTemp;
        }).collect(Collectors.toList());
        providerTempMapper.insertList(providerTemps);
        map = null;
    }

    @Override
    public String selectTemp() {
        List<DateView> list = providerMapper.queryAll();
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(list);
        }
        list = providerMapper.queryAll();

        return toJson.buildJson(list);
    }
}
