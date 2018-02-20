package common.dao;

import common.model.param.PubtimeTemp;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PubtimeTempMapper {

    int insertList(List<PubtimeTemp> pressTemps);
}