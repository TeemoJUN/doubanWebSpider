package common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/spring-context.xml")
public class CreateMemoryTableTest {
    @Autowired
    private CreateMemoryTable createMemoryTable;
    @Test
    public void createPressTemp() {
        createMemoryTable.createPressTemp();
    }
}