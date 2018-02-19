package common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/spring-context.xml")
public class KeyServiceTest {
    @Autowired
    KeyService keyService;
    @Test
    public void selectTemp() {
        keyService.selectTemp();
    }
}