package spider.read.douban.com.service.processor;

import common.constant.EbookConstant;
import common.constant.ExtractText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spider.read.douban.com.model.EbookInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanzailin
 * @date 2017/12/22
 */
public class EbookPageProcessor implements PageProcessor {
    Logger logger = LoggerFactory.getLogger(EbookPageProcessor.class);
    Site site = Site.me().setCharset("UTF-8").addHeader("Accept-Encoding", "/")
            .setRetrySleepTime(2).setSleepTime(2000).setTimeOut(7000);

    @Override
    public void process(Page page) {
        createEbookInfo(page);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void createEbookInfo(Page page) {

        Html html = page.getHtml();

        EbookInfo ebookInfo = new EbookInfo();
        ebookInfo.setNo(ExtractText.getInteger(page.getUrl().get()).toString());

        try {
            ebookInfo.setTitle(html.xpath(EbookConstant.TITLE_XPATH).get());
        } catch (NullPointerException e) {
            page.setSkip(true);
            logger.debug("Title {} 为NULL", e);
        }
        try {
            ebookInfo.setAuthorName(html.xpath(EbookConstant.AUTHOR_NAME_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("AuthorName 为NULL {}", e);
        }
        try {

            ebookInfo.setComments(ExtractText.getComments(html.xpath(EbookConstant.COMMENTS_XPATH).get()));
        } catch (NullPointerException e) {
            logger.debug("Comments 为NULL {}", e);
        }

        try {
            ebookInfo.setCurrentPrice(ExtractText.getCurrentPrice(
                    html.xpath(EbookConstant.CURRENT_PRICE_XPATH).get()));
        } catch (Exception e) {
            logger.debug("CurrentPrice 为NULL {}", e);
        }

        try {
            ebookInfo.setLabel(html.xpath(EbookConstant.LABEL_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("Label {} 为NULL", e);
        }
        try {
            ebookInfo.setSubtitle(html.xpath(EbookConstant.SUBTITLE_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("Subtitle {} 为NULL", e);
        }
        try {
            ebookInfo.setKeyWords(ExtractText.getKeyWords(html.xpath(EbookConstant.KEY_WORDS_XPATH).get()));

        } catch (NullPointerException e) {
            logger.debug("KeyWords {} 为NULL", e);
        }
        try {
            ebookInfo.setPress(html.xpath(EbookConstant.PRESS_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("Press {} 为NULL", e);
        }
        try {
            ebookInfo.setRating(ExtractText.stringToDouble(html.xpath(EbookConstant.RATING_XPATH).get()));

        } catch (NullPointerException e) {
            logger.debug("Rating {} 为NULL", e);
        }
        try {
            ebookInfo.setProvider(html.xpath(EbookConstant.PROVIDER_XPATH).get());

        } catch (NullPointerException e) {
            logger.debug("Provider {} 为NULL", e);
        }
        try {
            ebookInfo.setTranslator(ExtractText.getText(html.xpath(
                    EbookConstant.TRANSLATOR_XPATH).get(), ExtractText.GET_A_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.debug("Translator {} 为NULL", e);
        }
        try {
            ebookInfo.setWordCount(ExtractText.getWordCount(html.xpath(EbookConstant.WORD_COUNT_XPATH).all()));
        } catch (NullPointerException e) {
            logger.debug("WordCount {} 为NULL", e);
        }
        try {
            ebookInfo.setDescription(ExtractText.getText(html.xpath(EbookConstant.DESCRIPTION_XPATH).get(),
                    ExtractText.GET_P_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.debug("Description {} 为NULL", e);
        }
        try {
            ebookInfo.setPopularAnnotations(ExtractText.getText(html.xpath(EbookConstant.POPULAR_ANNOTATIONS_XPATH)
                    .get(), ExtractText.GET_A_TEXT_REGEX));
        } catch (NullPointerException e) {
            logger.debug("PopularAnnotations {} 为NULL", e);
        }
        try {
            ebookInfo.setUrl(page.getUrl().get());

        } catch (NullPointerException e) {
            logger.debug("Url {} 为NULL", e);
        }
        page.putField("ebookInfo", ebookInfo);
        List<String> list = cleanUrl(html.links().regex("https://read\\.douban\\.com/ebook/\\d+/.*").all());
        page.addTargetRequests(list);
    }

    /**
     * 将所有的url规范化
     *
     * @param urls
     * @return
     */
    private List<String> cleanUrl(List<String> urls) {
        List<String> result = new ArrayList<String>();
        for (String url : urls) {
            result.add(ExtractText.getText(url, ExtractText.GET_CLEAN_URL_REGEX));
        }
        return result;
    }
}
