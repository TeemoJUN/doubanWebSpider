package cn.webspider.web.controller;


import common.service.AnalyzeTempDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 根据数据来分析
 *
 * @author wanzailin
 * @date 2018/01/14
 */
@Controller
@RequestMapping("/cn/zailin/ebook/analyze")
public class AnalyzeController {
    @Autowired
    private AnalyzeTempDelegate analyzeTempDelegate;

    @RequestMapping(path = "/{item}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String press(@PathVariable String item){
        return analyzeTempDelegate.selectTemp(item);
    }
}
