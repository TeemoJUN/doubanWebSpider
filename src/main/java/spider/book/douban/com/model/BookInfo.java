package spider.book.douban.com.model;

import java.util.Date;

public class BookInfo {
    /**
     * 唯一主键
     */
    private Integer id;
    /**
     * url中的唯一表识
     */
    private String no;
    /**
     * 书名
     */
    private String title;
    /**
     * 作者
     */
    private String authorName;
    /**
     * 出版社
     */
    private String press;
    /**
     * 原书名
     */
    private String originalTitle;
    /**
     * 译者
     */
    private String translator;
    /**
     * 出版时间
     */
    private Date pubtime;
    /**
     * 页数
     */
    private Integer pages;
    /**
     * 定价
     */
    private Double price;
    /**
     * 装帧
     */
    private String binding;
    /**
     * 丛书
     */
    private String series;
    /**
     * isbn号
     */
    private String isbn;
    /**
     * 评分
     */
    private Double rating;
    /**
     * 评价人数
     */
    private Integer comments;
    /**
     * 内容简介
     */
    private String contentInfo;
    /**
     * 作者简介
     */
    private String authorInfo;
    /**
     * 豆瓣成员常用标签
     */
    private String userTags;
    /**
     * 喜欢这本书的人也喜欢的电子书
     */
    private String alsoLikeEbook;
    /**
     * 喜欢这本书的人也喜欢读
     */
    private String alsoLikeBook;
    /**
     * 短评数
     */
    private Integer shortCommentsNum;
    /**
     * 书评数
     */
    private Integer bookCommentsNum;
    /**
     * 读书笔记数
     */
    private Integer readingNotesNum;
    /**
     * 正在读的人数
     */
    private Integer readingsNum;
    /**
     * 读过的人数
     */
    private Integer hasReadNum;
    /**
     * 想读的人数
     */
    private Integer wantReadNum;
    /**
     * 其它版本
     */
    private String otherVersions;
    /**
     * 链接地址
     */
    private String url;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle == null ? null : originalTitle.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
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

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo == null ? null : contentInfo.trim();
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo == null ? null : authorInfo.trim();
    }

    public String getUserTags() {
        return userTags;
    }

    public void setUserTags(String userTags) {
        this.userTags = userTags == null ? null : userTags.trim();
    }

    public String getAlsoLikeEbook() {
        return alsoLikeEbook;
    }

    public void setAlsoLikeEbook(String alsoLikeEbook) {
        this.alsoLikeEbook = alsoLikeEbook == null ? null : alsoLikeEbook.trim();
    }

    public String getAlsoLikeBook() {
        return alsoLikeBook;
    }

    public void setAlsoLikeBook(String alsoLikeBook) {
        this.alsoLikeBook = alsoLikeBook == null ? null : alsoLikeBook.trim();
    }

    public Integer getShortCommentsNum() {
        return shortCommentsNum;
    }

    public void setShortCommentsNum(Integer shortCommentsNum) {
        this.shortCommentsNum = shortCommentsNum;
    }

    public Integer getBookCommentsNum() {
        return bookCommentsNum;
    }

    public void setBookCommentsNum(Integer bookCommentsNum) {
        this.bookCommentsNum = bookCommentsNum;
    }

    public Integer getReadingNotesNum() {
        return readingNotesNum;
    }

    public void setReadingNotesNum(Integer readingNotesNum) {
        this.readingNotesNum = readingNotesNum;
    }

    public Integer getReadingsNum() {
        return readingsNum;
    }

    public void setReadingsNum(Integer readingsNum) {
        this.readingsNum = readingsNum;
    }

    public Integer getHasReadNum() {
        return hasReadNum;
    }

    public void setHasReadNum(Integer hasReadNum) {
        this.hasReadNum = hasReadNum;
    }

    public Integer getWantReadNum() {
        return wantReadNum;
    }

    public void setWantReadNum(Integer wantReadNum) {
        this.wantReadNum = wantReadNum;
    }

    public String getOtherVersions() {
        return otherVersions;
    }

    public void setOtherVersions(String otherVersions) {
        this.otherVersions = otherVersions == null ? null : otherVersions.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}