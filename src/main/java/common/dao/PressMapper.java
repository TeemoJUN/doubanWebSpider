package common.dao;

import common.model.vo.DateView;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 出版商显示使用
 *
 * @author wanzailin
 * @date 2018/01/23
 */
@Repository
public interface PressMapper {
    List<DateView> queryAll();
}
