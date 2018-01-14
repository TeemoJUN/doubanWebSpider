package cn.zailin.webspider.service;

import cn.zailin.webspider.dao.SelectTopMapper;
import cn.zailin.webspider.model.param.BasicSelectParam;
import cn.zailin.webspider.model.vo.BasicSelectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询前几的书籍
 * @author wanzailin
 * @date 2018/01/14
 */
@Service
public class SelectTopService {
    @Resource
    private SelectTopMapper selectTopMapper;
    @Autowired
    private ToJson toJson;

    /**
     * 查询结果
     *
     * @param basicSelectParam
     * @return Json
     */
    public String selectTop(BasicSelectParam basicSelectParam) {
        if (!checkParam(basicSelectParam)) {
            return "参数错误";
        }
        if(basicSelectParam.getTop()<0){
            return "top参数有误";
        }
        List<BasicSelectView> list = selectTopMapper.selectTop(basicSelectParam);

        return toJson.buildJson(list);
    }

    /**
     * 判断是否只有一个为真的
     *
     * @param basicSelectParam
     * @return
     */
    private boolean checkParam(BasicSelectParam basicSelectParam) {
        if (basicSelectParam.getComments() && !basicSelectParam.getRating() && !basicSelectParam.getCurrentPrice()
                && !basicSelectParam.getWordCount()) {
            return true;
        }else if (!basicSelectParam.getComments() && basicSelectParam.getRating() && !basicSelectParam.getCurrentPrice()
                && !basicSelectParam.getWordCount()) {
            return true;
        }else if (!basicSelectParam.getComments() && !basicSelectParam.getRating() && basicSelectParam.getCurrentPrice()
                && !basicSelectParam.getWordCount()) {
            return true;
        }else if (!basicSelectParam.getComments() && !basicSelectParam.getRating() && !basicSelectParam.getCurrentPrice()
                && basicSelectParam.getWordCount()) {
            return true;
        }
        return false;
    }


}
