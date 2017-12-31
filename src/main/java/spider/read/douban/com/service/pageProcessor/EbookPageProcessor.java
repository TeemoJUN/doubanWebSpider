package spider.read.douban.com.service.pageProcessor;

import com.google.common.collect.Sets;
import common.constant.EbookConstant;
import common.constant.ExtractText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spider.read.douban.com.model.EbookInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.Set;

public class EbookPageProcessor implements PageProcessor {
    static Logger logger = LoggerFactory.getLogger(EbookPageProcessor.class);
    Set<Integer> set = Sets.newHashSet();

    public void process(Page page) {
        String url = page.getUrl().get();
        Integer no = ExtractText.getInteger(url);
        if (set.contains(no)) {
            page.setSkip(true);
        }

        createEbookInfo(page);
    }

    public Site getSite() {
        return Site.me();
    }

    public static void createEbookInfo(Page page) {

        Html html = page.getHtml();

        EbookInfo ebookInfo = new EbookInfo();

        ebookInfo.setNo(ExtractText.getInteger(page.getUrl().get()).toString());

        try {
            ebookInfo.setTitle(html.xpath(EbookConstant.TITLE_XPATH).get());
        } catch (NullPointerException e) {
            logger.info("Title  为NULL");
        }
        try {
            ebookInfo.setAuthorName(html.xpath(EbookConstant.AUTHOR_NAME_XPATH).get());
        } catch (NullPointerException e) {
            logger.info("AuthorName 为NULL");
        }
        try {

            ebookInfo.setComments(ExtractText.stringToInteger(html.xpath(EbookConstant.COMMENTS_XPATH).get()));
        } catch (NullPointerException e) {
            logger.info("Comments 为NULL");
        }

        try {

            ebookInfo.setCurrentPrice(ExtractText.stringToDouble(html.xpath(EbookConstant.CURRENT_PRICE_XPATH).get()));
        } catch (NullPointerException e) {
            logger.info("CurrentPrice 为NULL");
        }

        try {
            ebookInfo.setLabel(html.xpath(EbookConstant.LABEL_XPATH).get());
        } catch (NullPointerException e) {
            logger.info("Label 为NULL");
        }
        try {

            ebookInfo.setSubtitle(html.xpath(EbookConstant.SUBTITLE_XPATH).get());
        } catch (NullPointerException e) {
            logger.info("Subtitle 为NULL");
        }
        try {
            ebookInfo.setKeyWords(html.xpath(EbookConstant.KEY_WORDS_XPATH).get());

        } catch (NullPointerException e) {
            logger.info("KeyWords 为NULL");
        }
        try {

            ebookInfo.setPress(html.xpath(EbookConstant.PRESS_XPATH).get());
        } catch (NullPointerException e) {
            logger.info("Press 为NULL");
        }
        try {
            ebookInfo.setRating(ExtractText.stringToDouble(html.xpath(EbookConstant.RATING_XPATH).get()));

        } catch (NullPointerException e) {
            logger.info("Rating 为NULL");
        }
        try {
            ebookInfo.setProvider(html.xpath(EbookConstant.PROVIDER_XPATH).get());

        } catch (NullPointerException e) {
            logger.info("Provider 为NULL");
        }
        try {
            ebookInfo.setTranslator(html.xpath(EbookConstant.TRANSLATOR_XPATH).get());

        } catch (NullPointerException e) {
            logger.info("Translator 为NULL");
        }
      //@TODO 要将从文字用提取数字
        //ebookInfo.setWordCount(html.xpath(EbookConstant.WORD_COUNT_XPATH).get());
        try {
            ebookInfo.setDescription(ExtractText.getText(html.xpath(EbookConstant.DESCRIPTION_XPATH).get(), ExtractText.GET_P_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.info("Description 为NULL");
        }
        try {
            ebookInfo.setPopularAnnotations(ExtractText.getText(html.xpath(EbookConstant.POPULAR_ANNOTATIONS_XPATH).get(), ExtractText.GET_A_TEXT_REGEX));

        } catch (NullPointerException e) {
            logger.info("PopularAnnotations 为NULL");
        }
        try {
            ebookInfo.setUrl(page.getUrl().get());

        } catch (NullPointerException e) {
            logger.info("Url 为NULL");
        }
        page.putField("ebookInfo", ebookInfo);


    }


}
