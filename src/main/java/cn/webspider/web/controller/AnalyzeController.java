package cn.webspider.web.controller;


import common.service.CreateMemoryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 根据数据来分析
 *
 * @author wanzailin
 * @date 2018/01/14
 */
@Controller
@RequestMapping("/cn/zailin/ebook")
public class AnalyzeController {
    @Autowired
    private CreateMemoryTable createMemoryTable;
    @RequestMapping(value = "/press",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void press(){
        createMemoryTable.selectPressTemp();
    }
}
