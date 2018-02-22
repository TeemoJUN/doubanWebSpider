package common.dao;

import common.model.param.RatingTemp;
import common.model.vo.DateView;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface RatingMapper {
    List<DateView> queryAll();
    int insertList(List<RatingTemp> pressTemps);
}
