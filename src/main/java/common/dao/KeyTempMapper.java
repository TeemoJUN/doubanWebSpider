package common.dao;

import common.model.param.KeyTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyTempMapper {
    int insertList(List<KeyTemp> KeyTemps);
}