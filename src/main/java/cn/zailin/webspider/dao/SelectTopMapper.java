package cn.zailin.webspider.dao;

import cn.zailin.webspider.model.param.BasicSelectParam;
import cn.zailin.webspider.model.vo.BasicSelectView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 基于基本查询查询top前几的书籍
 * @author wanzailin
 * @date 2018/01/14
 */
@Repository
public interface SelectTopMapper {
    public List<BasicSelectView> selectTop(BasicSelectParam basicSelectParam);
}
