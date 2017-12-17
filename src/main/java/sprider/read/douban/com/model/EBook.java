package sprider.read.douban.com.model;

public class EBook {

    private String no;

    private String title;

    private String subtitle;

    private String authorName;

    private String translator;

    private String label;

    private String press;

    private String provider;

    private String wordCount;

    private String rating;

    private String comments;

    private String currentPrice;

    private String description;

    private String popularAnnotations;

    private String keyWords;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

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

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
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

    @Override
    public String toString() {
        return "EBook{" +
                "no='" + no + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", translator='" + translator + '\'' +
                ", label='" + label + '\'' +
                ", press='" + press + '\'' +
                ", provider='" + provider + '\'' +
                ", wordCount='" + wordCount + '\'' +
                ", rating='" + rating + '\'' +
                ", comments='" + comments + '\'' +
                ", currentPrice='" + currentPrice + '\'' +
                ", description='" + description + '\'' +
                ", popularAnnotations='" + popularAnnotations + '\'' +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }
}
