package common.dao;

import common.model.param.KeyTemp;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyTemp record);

    int insertSelective(KeyTemp record);

    KeyTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyTemp record);

    int updateByPrimaryKey(KeyTemp record);
}