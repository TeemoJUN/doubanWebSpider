package common.service;


import cn.webspider.model.vo.BasicSelectView;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spider.read.douban.com.service.SavingTask;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class ToJson {
    Logger logger = LoggerFactory.getLogger(SavingTask.class);
    ObjectMapper mapper = new ObjectMapper();

    public String buildJson(List<?> list) {
        checkNotNull(list);
        try{
            return mapper.writeValueAsString(list);
        }catch (IOException e){
            logger.warn("解析失败 {}",e,list);
        }
        return null;
    }

    public String buildJson(Map<String,Integer> map){
        checkNotNull(map);
        try {
            return mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
