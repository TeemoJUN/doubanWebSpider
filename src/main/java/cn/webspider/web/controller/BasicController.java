package cn.webspider.web.controller;


import cn.webspider.model.param.BasicSelectParam;
import cn.webspider.service.SelectTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基本的显示
 *
 * @author wanzailin
 * @date 2018/01/14
 */
@Controller
@RequestMapping("/cn/zailin/ebook")
public class BasicController {

    @Autowired
    private SelectTopService selectTopService;

    @RequestMapping(value = "/basic",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectTop(BasicSelectParam basicSelectParam) {
        return selectTopService.selectTop(basicSelectParam);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testBasic(){
        System.out.println("AAA");
        return "aaa";
    }


}
