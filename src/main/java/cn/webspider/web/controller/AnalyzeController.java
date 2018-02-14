package cn.webspider.web.controller;


import common.service.PressService;
import common.service.ProviderService;
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
    private PressService pressService;
    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/press",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String press(){
        return pressService.selectTemp();
    }

    @RequestMapping(value = "/provider",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String provider(){
        return providerService.selectTemp();
    }
}
