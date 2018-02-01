package spider.read.douban.com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spider.read.douban.com.model.EbookInfo;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合，
 * @author wanzailin
 * @date 2018/01/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration("classpath:spring/dao.xml")
public class EbookInfoMapperTest {


    @Resource
    //这个爆红是没有关系的因为加载的时候会自动生成该bean
    private EbookInfoMapper ebookInfoMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {

    }


    @Test
    public void selectByPrimaryKey() throws Exception {
        int i=100;
        System.out.println(ebookInfoMapper.selectByPrimaryKey(3160));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectListByAny()throws Exception{
        EbookInfo ebookInfo=new EbookInfo();
        //ebookInfo.setAuthorName("王小波");
        //ebookInfo.setRating(8.8);
        ebookInfo.setPubtime(LocalDate.of(2012, 1, 2));
        List<EbookInfo> list=ebookInfoMapper.selectListByAny(ebookInfo);

        System.out.println("-----------"+list.toString());
    }

}