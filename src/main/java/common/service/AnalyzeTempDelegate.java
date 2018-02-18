package common.service;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class AnalyzeTempDelegate {

     private Map<String, CreateTemp> delegateMap;

     @Resource
     private void buildMap(List<CreateTemp> list){
         delegateMap= Maps.newHashMap();
         list.stream().forEach(service->{
             String s=service.getClass().getSimpleName();
             delegateMap.put(s,service);
         });
     }

     public String selectTemp(String s){
         String service=s+"Service";

         return delegateMap.get(service).selectTemp();
     }
}
