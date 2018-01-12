package spider.read.douban.com.service.processor;

import common.constant.EbookConstant;
import common.constant.EbookExtractText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
@Service
public class EbookPageProcessor implements PageProcessor {

    Logger logger = LoggerFactory.getLogger(EbookPageProcessor.class);

    Site site = Site.me().setCharset("UTF-8").addHeader("Accept-Encoding", "/").setRetrySleepTime(2)
            .setSleepTime(5000).setTimeOut(7000);

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

        List<String> list = cleanUrl(html.links().regex("https://read\\.douban\\.com/.*").all());
        page.addTargetRequests(list);

        String no = EbookExtractText.getInteger(page.getUrl().get()).toString();
        if (no == null) {
            page.setSkip(true);
            return;
        } else {
            ebookInfo.setNo(no);
        }

        String title = html.xpath(EbookConstant.TITLE_XPATH).get();
        if (title == null) {
            page.setSkip(true);
            return;
        } else {
            ebookInfo.setTitle(title);
        }

        ebookInfo.setAuthorName(html.xpath(EbookConstant.AUTHOR_NAME_XPATH).get());

        ebookInfo.setComments(EbookExtractText.getComments(html.xpath(EbookConstant.COMMENTS_XPATH).get()));

        ebookInfo.setCurrentPrice(EbookExtractText.getCurrentPrice(html.xpath(EbookConstant.CURRENT_PRICE_XPATH)
                .get()));

        ebookInfo.setLabel(html.xpath(EbookConstant.LABEL_XPATH).get());

        ebookInfo.setSubtitle(html.xpath(EbookConstant.SUBTITLE_XPATH).get());

        ebookInfo.setKeyWords(EbookExtractText.getKeyWords(html.xpath(EbookConstant.KEY_WORDS_XPATH).get()));

        ebookInfo.setPress(html.xpath(EbookConstant.PRESS_XPATH).get());

        ebookInfo.setRating(EbookExtractText.stringToDouble(html.xpath(EbookConstant.RATING_XPATH).get()));

        ebookInfo.setProvider(html.xpath(EbookConstant.PROVIDER_XPATH).get());

        ebookInfo.setTranslator(EbookExtractText.getText(html.xpath(EbookConstant.TRANSLATOR_XPATH).get(),
                EbookExtractText.GET_A_TEXT_REGEX));

        ebookInfo.setWordCount(EbookExtractText.getWordCount(html.xpath(EbookConstant.WORD_COUNT_XPATH).all()));

        ebookInfo.setDescription(EbookExtractText.getText(html.xpath(EbookConstant.DESCRIPTION_XPATH).get(),
                EbookExtractText.GET_P_TEXT_REGEX));

        ebookInfo.setPopularAnnotations(EbookExtractText.getText(html.xpath(EbookConstant.POPULAR_ANNOTATIONS_XPATH)
                .get(), EbookExtractText.GET_A_TEXT_REGEX));

        ebookInfo.setUrl(page.getUrl().get());

        ebookInfo.setPubtime(EbookExtractText.stringToDate(html.xpath(EbookConstant.PUBTIME_XPATH).get()));

        page.putField("ebookInfo", ebookInfo);

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
            result.add(EbookExtractText.getText(url, EbookExtractText.GET_CLEAN_URL_REGEX));
        }
        return result;
    }
}
