package cn.zailin.webspider.dao;

import cn.zailin.webspider.model.param.BasicSelectParam;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/dao.xml")
public class SelectTopMapperTest {
    @Resource
    private SelectTopMapper selectTopMapper;
    ObjectMapper objectMapper=new ObjectMapper();
    @Test
    public void selectTop() throws Exception {
        BasicSelectParam basicSelectParam = new BasicSelectParam();
        basicSelectParam.setComments(true);
        basicSelectParam.setTop(10);
        List list=selectTopMapper.selectTop(basicSelectParam);
        System.out.println(objectMapper.writeValueAsString(list));
    }

}