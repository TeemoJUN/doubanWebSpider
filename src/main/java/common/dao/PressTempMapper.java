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

    int insertList(List<PressTemp> pressTemps);
}