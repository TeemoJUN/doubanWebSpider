package common.service;

import common.model.vo.MaxAndMin;
import org.springframework.beans.factory.annotation.Autowired;
import spider.read.douban.com.dao.EbookInfoMapper;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 临时表的创建
 *
 * @author wanzailin
 * @date 2018/02/02
 */

public abstract class CreateTemp {

    protected final static int SELECT_LENGTH = 2000;

    private static volatile Boolean flag = true;
    @Resource
    protected EbookInfoMapper ebookInfoMapper;


    @Autowired
    protected ToJson toJson;

    private ReentrantLock lock = new ReentrantLock(true);

    private MaxAndMin selectMaxMin() {
        return ebookInfoMapper.queryMinMax();
    }

    public void createTempTable() {
        lock.lock();
        if (!flag) {
            lock.unlock();
            return;
        }
        MaxAndMin maxAndMin = selectMaxMin();
        int hi = maxAndMin.getMax()-maxAndMin.getMin()+1;
        int len=hi%SELECT_LENGTH==0 ? hi : (hi/SELECT_LENGTH+1)*SELECT_LENGTH;
        extract(len);
        save();
        flag = false;
        lock.unlock();
    }


    abstract void extract(int len);
    abstract void save();

    abstract String selectTemp();

}
