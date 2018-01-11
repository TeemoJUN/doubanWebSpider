package spider.read.douban.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spider.read.douban.com.dao.EbookInfoMapper;
import spider.read.douban.com.model.EbookInfo;
import spider.read.douban.com.service.scheduler.NumberDuplicateRemover;

import javax.annotation.Resource;
import java.util.concurrent.BlockingDeque;

/**
 * @author wanzailin
 * @2018/01/10
 */

public class SavingTask implements Runnable {
    Logger logger = LoggerFactory.getLogger(SavingTask.class);
    public EbookInfoMapper getEbookInfoMapper() {
        return ebookInfoMapper;
    }

    public void setEbookInfoMapper(EbookInfoMapper ebookInfoMapper) {
        this.ebookInfoMapper = ebookInfoMapper;
    }
    private volatile int i=0;
    //@Resource
    private EbookInfoMapper ebookInfoMapper;

    private BlockingDeque<EbookInfo> blockingDeque;

    private volatile boolean isStop = false;

    public SavingTask(BlockingDeque<EbookInfo> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true) {
            if (isStop) {
                return;
            }
            EbookInfo ebookInfo = blockingDeque.poll();
            if (ebookInfo == null) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                synchronized (this){
                    try{
                        ebookInfoMapper.insertSelective(ebookInfo);
                        logger.info("-------------存贮了：{}------------",++i);
                    }catch (Exception e){
                        logger.error("-------出现问题------{}---{}",e,ebookInfo );
                    }

                }
            }
        }
    }

    public void startSave() {
        this.isStop = true;
    }

    public void stopSave() {
        this.isStop = true;
    }

}
