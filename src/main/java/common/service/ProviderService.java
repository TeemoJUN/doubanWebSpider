package common.service;

import com.google.common.collect.Maps;
import common.dao.ProviderMapper;
import common.model.param.ProviderTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Service;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProviderService extends CreateTemp {
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
        providerMapper.insertList(providerTemps);
    }

    @Override
    public String selectTemp() {
        Map<String,Object> map= Maps.newHashMap();
        map.put("dataName","供应商对比图");
        List<DateView> list = providerMapper.queryAll();
        map.put("data",list);
        if (list.size() == 0) {
            createTempTable();
        } else {
            return toJson.buildJson(map);
        }
        list = providerMapper.queryAll();

        return toJson.buildJson(map);
    }
}
