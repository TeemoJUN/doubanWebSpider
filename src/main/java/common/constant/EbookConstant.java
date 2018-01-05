package common.constant;

/**
 * @author wanzailin
 * @date 2017/12/11
 */
public class EbookConstant {

    /**
     * 抽取eBook的url的中唯一编号
     */
    public static final String NO_REGEX = "/(\\d+)";

    /**
     * 抽取eBook中书名
     */
    public static final String TITLE_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/h1[@class='article-title" +
            "']/text()";

    /**
     * 抽取eBook中子标题
     */
    public static final String SUBTITLE_XPATH =
            "/html/body/div/div[2]/article/div[1]/div[2]/p[@class='subtitle']/text()";

    /**
     * 抽取eBook中的作者
     */
    public static final String AUTHOR_NAME_XPATH =
            "/html/body/div/div[2]/article/div[1]/div[2]/div[1]/p[@class='author']/span[2]/a[@class='author-item" +
                    "']/text()";

    /**
     * 抽取eBook中的译者，
     */
    public static final String TRANSLATOR_XPATH =
            "/html/body/div/div[2]/article/div[1]/div[2]/div[1]/p[@class='translator']/span[2]/a[@class='author-item']";

    /**
     * 抽取eBook中的书籍类别
     */
    public static final String LABEL_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/div[1]/p[@class='category" +
            "']/span[2]/span[@itemprop='genre']/text()";

    /**
     * 抽取eBook中的书籍出版社
     */
    public static final String PRESS_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/div[1]/p[@class!='category" +
            "']/span[2]/span[1]/text()";

    /**
     * 抽取eBook中的书籍出版日期
     */
    public static final String PUBTIME_XPATH =
            "/html/body/div/div[2]/article/div[1]/div[2]/div[1]/p[@class!='category']/span[2]/span[2]/text()";

    /**
     * 抽取eBook中的书籍提供方
     */
    public static final String PROVIDER_XPATH =
            "/html/body/div/div[2]/article/div[1]/div[2]/div[1]//p/span[2]/a[@itemprop='provider']/text()";

    /**
     * 抽取eBook中的书籍字数
     */
    public static final String WORD_COUNT_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/div[1]//p/span[2]/text" +
            "()";

    /**
     * 抽取eBook中的书籍豆瓣评分
     */
    public static final String RATING_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/a/span[1]/text()";

    /**
     * 抽取eBook中的书籍评价人数
     */
    public static final String COMMENTS_XPATH = "/html/body/div/div[2]/article/div[1]/div[2]/a/span[2]/text()";

    /**
     * 抽取eBook中的书籍定价
     */
    public static final String CURRENT_PRICE_XPATH =
            "/html/body/div/div[2]/article/div[2]/div[1]/span[1]/span/span/text()";

    /**
     * 抽取eBook中的书籍导言，
     */
    public static final String DESCRIPTION_XPATH = "/html/body/div/div[2]/article/div[3]/div[2]/div";

    /**
     * 抽取eBook中的书籍热门划线，
     */
    public static final String POPULAR_ANNOTATIONS_XPATH = "/html/body/div/div[2]/article/div[3]/div[2]/div[2]/ol";

    /**
     * 抽取eBook中的书籍作平标签
     */
    public static final String KEY_WORDS_XPATH = "/html/body/div/div[2]/aside//section/div[2]/meta";


}
