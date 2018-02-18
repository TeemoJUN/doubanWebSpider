package common.dao;

import common.model.param.RatingTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RatingTemp record);

    int insertSelective(RatingTemp record);

    RatingTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RatingTemp record);

    int updateByPrimaryKey(RatingTemp record);
    int insertList(List<RatingTemp> pressTemps);
}