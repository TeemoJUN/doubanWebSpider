package common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractText {
    static Logger logger = LoggerFactory.getLogger(ExtractText.class);

    /**
     * 抽取url中的豆瓣书籍编号
     */
    public static final String GET_URL_REGEX="/(\\d+)";

    /**
     * 抽取a标签中的文本
     */
    public static final String GET_A_TEXT_REGEX="<a[^>]*>([^<]*)</a>";

    /**
     * 抽取p标签中的文本
     */
    public static final String GET_P_TEXT_REGEX="<p[^>]*>([^<]*)</p>";

    public static String getText(String str,String regex){
        StringBuffer stringBuffer=new StringBuffer();
        Pattern pattern=Pattern.compile(regex);
        Matcher m=pattern.matcher(str);
        while(m.find()){
            stringBuffer.append(m.group(1));
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    public static Integer getInteger(String url){
        Integer result;
        String temp = null;
        Pattern pattern=Pattern.compile(GET_URL_REGEX);
        Matcher m=pattern.matcher(url);
        while(m.find()){
            temp=m.group(1);
        }
        try{
            result=Integer.parseInt(temp);
            return result;
        }catch (NumberFormatException e){
            logger.info("url数据转换异常 {}",temp);
        }
        return null;
    }
}
