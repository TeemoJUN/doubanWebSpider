package spider.read.douban.com.dao;

import spider.read.douban.com.model.EbookInfo;

public interface EbookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EbookInfo record);

    int insertSelective(EbookInfo record);

    EbookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EbookInfo record);

    int updateByPrimaryKey(EbookInfo record);
}