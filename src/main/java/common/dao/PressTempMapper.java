package common.dao;

import common.model.param.PressTemp;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PressTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PressTemp record);

    int insertSelective(PressTemp record);

    PressTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PressTemp record);

    int updateByPrimaryKey(PressTemp record);

    int insertList(List<PressTemp> pressTemps);
}