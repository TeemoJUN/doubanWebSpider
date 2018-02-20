package common.dao;

import common.model.param.RatingTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingTempMapper {

    int insertList(List<RatingTemp> pressTemps);
}