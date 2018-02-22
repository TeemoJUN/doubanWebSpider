package common.dao;

import common.model.param.ProviderTemp;
import common.model.vo.DateView;

import java.util.List;

/**
 * 供应商的显示查询
 * @author wanzailin
 * @date 2018/01/25
 */
public interface ProviderMapper {
    List<DateView> queryAll();
    int insertList(List<ProviderTemp> pressTemps);
}
