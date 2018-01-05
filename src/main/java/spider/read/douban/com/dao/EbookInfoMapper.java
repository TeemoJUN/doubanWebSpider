package spider.read.douban.com.dao;

import spider.read.douban.com.model.EbookInfo;
/**
 * @author wanzailin
 * @date 2017/12/11
 */
public interface EbookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EbookInfo record);

    int insertSelective(EbookInfo record);

    EbookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EbookInfo record);

    int updateByPrimaryKey(EbookInfo record);
}