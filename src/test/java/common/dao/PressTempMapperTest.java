package common.dao;

import common.model.param.PressTemp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/dao.xml")
public class PressTempMapperTest {
    @Resource
    private PressMapper pressTempMapper;
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void insertList() {
        PressTemp pressTemp=new PressTemp();
        pressTemp.setNum(10);
        pressTemp.setPress("AAAA");
        PressTemp pressTemp1=new PressTemp();
        pressTemp1.setNum(100);
        pressTemp1.setPress("bbb");
        List<PressTemp> list=new ArrayList<PressTemp>();
        list.add(pressTemp);
        list.add(pressTemp1);
        System.out.println(pressTempMapper.insertList(list));
    }
}