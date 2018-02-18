package cn.webspider.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spider.read.douban.com.model.EbookInfo;

@Controller
@RequestMapping("/cn/zailin/ebook")
public class DetailsController {

    @RequestMapping(value = "/details",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String details(EbookInfo ebookInfo){
        //@TODO 详情分析
        return null;
    }
}
