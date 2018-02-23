package cn.webspider.service;

import cn.webspider.dao.SelectTopMapper;
import cn.webspider.model.param.BasicSelectParam;
import cn.webspider.model.param.PageParam;
import cn.webspider.model.vo.BasicSelectView;
import cn.webspider.model.vo.PageView;
import com.google.common.collect.Maps;
import common.service.ToJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 查询前几的书籍
 *
 * @author wanzailin
 * @date 2018/01/14
 */
@Service
public class SelectTopService {
    private Logger logger = LoggerFactory.getLogger(SelectTopService.class);
    @Resource
    private SelectTopMapper selectTopMapper;
    @Autowired
    private ToJson toJson;

    @Value(value = "${perPageRows}")
    private int perPageRows;

    /**
     * 查询结果,查询top几数据
     *
     * @param basicSelectParam
     * @return Json
     */
    public String selectTop(BasicSelectParam basicSelectParam) {
        if (!checkParam(basicSelectParam)&&(basicSelectParam.getPage() < 0)) {
            logger.info("参数错误--:{}", basicSelectParam);
            return "参数错误";
        }
        PageView pageView = calculate(basicSelectParam.getPage());
        if (pageView == null) {
            return "参数错误";
        }
        Map<String,Object> map= Maps.newHashMap();
        basicSelectParam.setStart((pageView.getCurrentPage() - 1) * perPageRows);
        basicSelectParam.setPerPageRows(perPageRows);
        List<BasicSelectView> list = selectTopMapper.selectTop(basicSelectParam);
        map.put("page",pageView);
        map.put("contain",list);
        return toJson.buildJson(map);
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
        } else if (!basicSelectParam.getComments() && basicSelectParam.getRating() && !basicSelectParam
                .getCurrentPrice()
                && !basicSelectParam.getWordCount()) {
            return true;
        } else if (!basicSelectParam.getComments() && !basicSelectParam.getRating() && basicSelectParam
                .getCurrentPrice()
                && !basicSelectParam.getWordCount()) {
            return true;
        } else if (!basicSelectParam.getComments() && !basicSelectParam.getRating() && !basicSelectParam
                .getCurrentPrice()
                && basicSelectParam.getWordCount()) {
            return true;
        }
        return false;
    }

    private PageView calculate(int nextPage) {
        if(nextPage==0){
            nextPage=1;
        }
        PageParam pageParam = selectTopMapper.queryRows();
        int count = pageParam.getRows();
        int totalPage;
        if (count % perPageRows == 0) {
            totalPage = count / perPageRows;
        } else {
            totalPage = count / perPageRows + 1;
        }
        if (nextPage < totalPage) {
            PageView pageView = new PageView();
            pageView.setAllPage(totalPage);
            pageView.setCurrentPage(nextPage);
            return pageView;
        }
        logger.info("nextPage错误:{},{}", nextPage, pageParam);
        return null;
    }


}
