package cn.webspider.dao;

import cn.webspider.model.param.BasicSelectParam;
import cn.webspider.service.SelectTopService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/spring-context.xml")
public class SelectTopMapperTest {

    @Autowired
    SelectTopService selectTopService;
    @Test
    public void selectTop() throws Exception {
        BasicSelectParam basicSelectParam = new BasicSelectParam();
        basicSelectParam.setComments(true);
        basicSelectParam.setStart(10);

        selectTopService.selectTop(basicSelectParam);
    }

}