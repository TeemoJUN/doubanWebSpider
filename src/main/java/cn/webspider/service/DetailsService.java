package cn.webspider.service;

import org.springframework.stereotype.Service;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;

@Service
public class DetailsService {
    @Resource
    private EbookInfoMapper ebookInfoMapper;

    //private
}
