package common.dao;

import common.model.param.LabelTemp;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LabelTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LabelTemp record);

    int insertSelective(LabelTemp record);

    LabelTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelTemp record);

    int updateByPrimaryKey(LabelTemp record);

    int insertList(List<LabelTemp> pressTemps);
}