package spider.read.douban.com.dao;

import org.springframework.stereotype.Repository;
import spider.read.douban.com.model.EbookInfo;

/**
 * @author wanzailin
 * @date 2017/12/11
 */

@Repository
public interface EbookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EbookInfo record);

    int insertSelective(EbookInfo record);

    EbookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EbookInfo record);

    int updateByPrimaryKey(EbookInfo record);

    //test@TODO,多个参数时mybatis无法识别
    //int selectByprimaryKey(@Param("AA") int AA,@Param("BB") int BB);
}