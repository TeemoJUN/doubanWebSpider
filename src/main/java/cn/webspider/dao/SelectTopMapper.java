package cn.webspider.dao;

import cn.webspider.model.param.BasicSelectParam;
import cn.webspider.model.vo.BasicSelectView;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 基于基本查询查询top前几的书籍
 * @author wanzailin
 * @date 2018/01/14
 */
@Repository
public interface SelectTopMapper {
    List<BasicSelectView> selectTop(BasicSelectParam basicSelectParam);
}
