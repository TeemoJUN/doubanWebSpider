package cn.webspider.model.vo;

import java.util.Date;

public class BasicSelectView {
    /**
     * 书名
     */
    private String title;
    /**
     * 子标题
     */
    private String subtitle;
    /**
     * 作者
     */
    private String authorName;
    /**
     * 译者
     */
    private String translator;
    /**
     * 类别
     */
    private String label;
    /**
     * 出版社
     */
    private String press;
    /**
     * 提供商
     */
    private String provider;
    /**
     * 字数
     */
    private Integer wordCount;
    /**
     * 评分
     */
    private Double rating;
    /**
     * 评论人数
     */
    private Integer comments;
    /**
     * 当前价格
     */
    private Double currentPrice;
    /**
     * 导言
     */
    private String description;
    /**
     * 热门划线
     */
    private String popularAnnotations;
    /**
     * 作品标签
     */
    private String keyWords;
    /**
     * 链接地址
     */
    private String url;
    /**
     * 出版时间
     */
    private Date pubtime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPopularAnnotations() {
        return popularAnnotations;
    }

    public void setPopularAnnotations(String popularAnnotations) {
        this.popularAnnotations = popularAnnotations;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    @Override
    public String toString() {
        return "BasicSelectView{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", translator='" + translator + '\'' +
                ", label='" + label + '\'' +
                ", press='" + press + '\'' +
                ", provider='" + provider + '\'' +
                ", wordCount=" + wordCount +
                ", rating=" + rating +
                ", comments=" + comments +
                ", currentPrice=" + currentPrice +
                ", description='" + description + '\'' +
                ", popularAnnotations='" + popularAnnotations + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", url='" + url + '\'' +
                ", pubtime=" + pubtime +
                '}';
    }
}
