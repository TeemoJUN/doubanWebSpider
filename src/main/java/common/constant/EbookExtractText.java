package common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EBook抽取文字信息
 *
 * @author wanzailin
 * @date 2017/12/11
 */
public class EbookExtractText {

    static Logger logger = LoggerFactory.getLogger(EbookExtractText.class);

    /**
     * 抽取纯净的url
     */
    public static final String GET_CLEAN_URL_REGEX = "(https://read\\.douban\\.com/ebook/\\d+)/.*";

    /**
     * 抽取url中的豆瓣书籍编号
     */
    public static final String GET_NUM_URL_REGEX = "/(\\d+)";

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
        try {
            return stringToInteger(string.split("\\ ")[0]);

        } catch (NullPointerException e) {
            logger.warn("Comments格式不对 {} {}", string, e);
        }
        return null;
    }

    /**
     * 获取价格
     *
     * @param string "￥7.99"
     * @return
     */
    public static Double getCurrentPrice(String string) {
        if (string == null) {
            return null;
        }
        return stringToDouble(string.replace("￥", ""));
    }

    /**
     * @param str
     * @param regex
     * @return
     */
    public static String getText(String str, String regex) {
        if (str == null) {
            return null;
        }
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
        Pattern pattern = Pattern.compile(GET_NUM_URL_REGEX);
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
            logger.info("stringToInteger格式化转换异常 {} {}", string, e);
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
        if (string == null) {
            logger.warn("string null");
            return null;
        }
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
        if (list.size() < 1) {
            return null;
        }
        String string;
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
        if (string == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(GET_KEY_WORLD_REGEX);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 获取url中的数字部分，若获取不到返回原来的
     *
     * @param str
     * @param regex
     * @return
     */
    public static String getNumber(String str, String regex) {
        if (str == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            str = m.group(1);
        }
        return str;
    }

    /**
     * 获取页面中的出版时间，并将其合理转换
     *
     * @param string "2017-10"
     * @return
     */
    public static Date stringToDate(String string) {
        if (string == null) {
            return null;
        }
        try {
            String[] s = string.split("-");
            int year = 0;
            int month = 0;
            int day = 2;
            switch (s.length) {
                case 1:
                    year = stringToInteger(s[0]) - 1900;
                    month = 1;
                    day = 2;
                    break;
                case 2:
                    year = stringToInteger(s[0]) - 1900;
                    month = stringToInteger(s[1]) - 1;
                    day = 2;
                    break;
                case 3:
                    year = stringToInteger(s[0]);
                    month = stringToInteger(s[1]);
                    day = stringToInteger(s[2])+1;
                    break;
                default:
                    return null;
            }
            Date date = new Date(year, month, day);
            return date;
        } catch (Exception e) {
            logger.warn("pubTime 获取失败 {} {}", e, string);
        }
        return null;
    }
}
