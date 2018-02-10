package common.dao;

import common.model.vo.DateView;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PressMapper {
    List<DateView> queryAll();
}
