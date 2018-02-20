package common.dao;

import common.model.param.LabelTemp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelTempMapper {

    int insertList(List<LabelTemp> pressTemps);
}