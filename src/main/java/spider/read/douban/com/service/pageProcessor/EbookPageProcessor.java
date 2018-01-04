package spider.read.douban.com.service.pageProcessor;

import com.google.common.collect.Maps;
import common.constant.EbookConstant;
import common.constant.ExtractText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spider.read.douban.com.model.EbookInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.concurrent.ConcurrentMap;

public class EbookPageProcessor implements PageProcessor {
    Logger logger = LoggerFactory.getLogger(EbookPageProcessor.class);
    Site site=Site.me().setCharset("UTF-8").addHeader("Accept-Encoding","/")
            .setRetrySleepTime(2).setSleepTime(2000);
            //.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

    public void process(Page page) {
        createEbookInfo(page);
    }

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
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setAuthorName(html.xpath(EbookConstant.AUTHOR_NAME_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {

            ebookInfo.setComments(ExtractText.getComments(html.xpath(EbookConstant.COMMENTS_XPATH).get()));
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }

        try {
            ebookInfo.setCurrentPrice(ExtractText.getCurrentPrice(html.xpath(EbookConstant.CURRENT_PRICE_XPATH).get()));
        } catch (Exception e) {
            logger.debug("{} 为NULL",e);
        }

        try {
            ebookInfo.setLabel(html.xpath(EbookConstant.LABEL_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setSubtitle(html.xpath(EbookConstant.SUBTITLE_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setKeyWords(ExtractText.getKeyWords(html.xpath(EbookConstant.KEY_WORDS_XPATH).get()));

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setPress(html.xpath(EbookConstant.PRESS_XPATH).get());
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setRating(ExtractText.stringToDouble(html.xpath(EbookConstant.RATING_XPATH).get()));

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setProvider(html.xpath(EbookConstant.PROVIDER_XPATH).get());

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setTranslator(ExtractText.getText(html.xpath(EbookConstant.TRANSLATOR_XPATH).get(),ExtractText.GET_A_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setWordCount(ExtractText.getWordCount(html.xpath(EbookConstant.WORD_COUNT_XPATH).all()));
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setDescription(ExtractText.getText(html.xpath(EbookConstant.DESCRIPTION_XPATH).get(), ExtractText.GET_P_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setPopularAnnotations(ExtractText.getText(html.xpath(EbookConstant.POPULAR_ANNOTATIONS_XPATH).get(), ExtractText.GET_A_TEXT_REGEX));
        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        try {
            ebookInfo.setUrl(page.getUrl().get());

        } catch (NullPointerException e) {
            logger.debug("{} 为NULL",e);
        }
        page.putField("ebookInfo", ebookInfo);
        page.addTargetRequests(html.links().regex("https://read\\.douban\\.com/ebook/\\d+/.*").all());
    }


}
