package common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switch {
    Logger logger = LoggerFactory.getLogger(Switch.class);
    private static volatile boolean flag=true;

    public synchronized void on(){
        flag=true;
        logger.info("--数据可查询--");
    }

    public synchronized void off(){
        flag=false;
        logger.info("--数据插入中--");
    }

    public boolean getFlag(){
        return flag;
    }
}
