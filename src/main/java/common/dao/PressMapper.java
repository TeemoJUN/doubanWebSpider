package common.dao;

import common.model.vo.PressView;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PressMapper {
    List<PressView> queryAll();
}
