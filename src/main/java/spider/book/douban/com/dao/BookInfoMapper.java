package spider.book.douban.com.dao;

import spider.book.douban.com.model.BookInfo;

/**
 * @author wanzailin
 * @date 2017/12/23
 */
public interface BookInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}