package common.dao;

import common.model.param.PressTemp;
import common.model.param.ProviderTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 根据内存表的基本查询
 * @author wanzailin
 * @date 2018/01/25
 */
@Repository
public interface ProviderTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProviderTemp record);

    int insertSelective(ProviderTemp record);

    ProviderTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProviderTemp record);

    int updateByPrimaryKey(ProviderTemp record);

    int insertList(List<ProviderTemp> pressTemps);
}