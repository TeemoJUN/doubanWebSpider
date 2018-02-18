package common.dao;

import common.model.param.PressTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 出版商的基本查询，根据mysql内存表的基本查询
 * @author wanzailin
 * @date 2018/01/23
 */
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