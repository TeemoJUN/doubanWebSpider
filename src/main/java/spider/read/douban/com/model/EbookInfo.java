package spider.read.douban.com.model;

import java.util.Date;

public class EbookInfo {
    /**
     * 唯一主键
     */
    private Integer id;
    /**
     * url中的数字
     */
    private String no;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
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
        this.description = description == null ? null : description.trim();
    }

    public String getPopularAnnotations() {
        return popularAnnotations;
    }

    public void setPopularAnnotations(String popularAnnotations) {
        this.popularAnnotations = popularAnnotations == null ? null : popularAnnotations.trim();
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    @Override
    public String toString() {
        return "EbookInfo{" +
                "id=" + id +
                ", \n no='" + no + '\'' +
                ", \n title='" + title + '\'' +
                ", \n subtitle='" + subtitle + '\'' +
                ", \n authorName='" + authorName + '\'' +
                ", \n translator='" + translator + '\'' +
                ", \n label='" + label + '\'' +
                ", \n press='" + press + '\'' +
                ", \n provider='" + provider + '\'' +
                ", \n wordCount=" + wordCount +
                ", \n rating=" + rating +
                ", \n comments=" + comments +
                ", \n currentPrice=" + currentPrice +
                ", \n description='" + description + '\'' +
                ", \n popularAnnotations='" + popularAnnotations + '\'' +
                ", \n keyWords='" + keyWords + '\'' +
                ", \n url='" + url + '\'' +
                ", \n pubtime=" + pubtime +
                "} \n";
    }
}