package common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractText {
    static Logger logger = LoggerFactory.getLogger(ExtractText.class);

    /**
     * 抽取url中的豆瓣书籍编号
     */
    public static final String GET_URL_REGEX = "/(\\d+)";

    /**
     * 抽取a标签中的文本
     */
    public static final String GET_A_TEXT_REGEX = "<a[^>]*>([^<]*)</a>";

    /**
     * 抽取p标签中的文本
     */
    public static final String GET_P_TEXT_REGEX = "<p[^>]*>([^<]*)</p>";

    /**
     * 抽取字数 例如： 约 125000 字
     */
    public static final String GET_WORLD_COUNT_REGEX = "\\ (\\d+)\\ ";
    /**
     * 抽取作品标签 例如 "<meta itemprop=\"keywords\" content=\"情感,悬疑,爱情小说,都市小说,限时特价\">";
     */
    public static final String GET_KEY_WORLD_REGEX = "content=\"(.*)\"";

    /**
     * 获取评论人数
     *
     * @param string "147 评论"
     * @return
     */
    public static Integer getComments(String string) {
        return stringToInteger(string.split("\\ ")[0]);
    }

    /**
     * 获取价格
     *
     * @param string "￥7.99"
     * @return
     */
    public static Double getCurrentPrice(String string) {
        return stringToDouble(string.replace("￥", ""));
    }

    /**
     * @param str
     * @param regex
     * @return
     */
    public static String getText(String str, String regex) {
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            stringBuffer.append(m.group(1));
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    /**
     * 从url中获取唯一数字编号
     *
     * @param url
     * @return
     */
    public static Integer getInteger(String url) {
        Integer result;
        String temp = null;
        Pattern pattern = Pattern.compile(GET_URL_REGEX);
        Matcher m = pattern.matcher(url);
        while (m.find()) {
            temp = m.group(1);
        }
        try {
            result = Integer.parseInt(temp);
            return result;
        } catch (NumberFormatException e) {
            logger.info("url数据转换异常 {}", temp);
        }
        return null;
    }

    /**
     * 字符串转换为整型
     *
     * @param string
     * @return
     */
    public static Integer stringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            logger.info("格式化转换异常 {}", string);
        }
        return null;
    }

    /**
     * 字符串转换为Double
     *
     * @param string
     * @return
     */
    public static Double stringToDouble(String string) {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            logger.warn("格式转换异常  {} {}", string, e);
        }
        return null;
    }

    /**
     * 抽取字数
     *
     * @param list [, , ,约 125,000 字]
     * @return
     */
    public static Integer getWordCount(List<String> list) {
        if (list == null) {
            logger.debug("getWordCount 抽取字数为空 {}", list);
        }
        if(list.size()<1){
            return null;
        }
        String string = null;
        try {
            string = list.get(list.size() - 1);
        } catch (Exception e) {
            logger.warn("抽取字数 {}", e);
            return null;
        }


        string = string.replace(",", "");

        Pattern pattern = Pattern.compile(GET_WORLD_COUNT_REGEX);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            string = matcher.group(1);
        }

        return stringToInteger(string);
    }

    /**
     * 作品标签
     *
     * @param string '<meta itemprop="keywords" content="情感,悬疑,爱情小说,都市小说,限时特价">'
     * @return
     */
    public static String getKeyWords(String string) {
        Pattern pattern = Pattern.compile(GET_KEY_WORLD_REGEX);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }


}
