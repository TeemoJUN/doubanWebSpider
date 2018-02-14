package common.dao;

import common.model.vo.DateView;

import java.util.List;

public interface ProviderMapper {
    List<DateView> queryAll();
}
