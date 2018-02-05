package common.service;

import common.model.vo.MaxAndMin;
import spider.read.douban.com.dao.EbookInfoMapper;

import javax.annotation.Resource;

/**
 * 临时表的创建
 *
 * @author wanzailin
 * @date 2018/02/02
 */
public class CreateMemoryTable {
    private final static int SELECT_LENGTH=2000;

    @Resource
    private EbookInfoMapper ebookInfoMapper;

    private MaxAndMin selectMaxMin(){
        return ebookInfoMapper.queryMinMax();
    }

    public void createPressTemp(){

    }



}
