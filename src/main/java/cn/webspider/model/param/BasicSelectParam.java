package cn.webspider.model.param;

/**
 * 基本查询(根据字数，评分，评论人数，当前价格，查询top前几的书籍)
 * @author wanzailin
 * @date 2018/01/14
 */

public class BasicSelectParam {
    /**
     * 字数
     */
    private  boolean wordCount;
    /**
     * 评分
     */
    private boolean rating;
    /**
     * 评论人数
     */
    private boolean comments;
    /**
     * 当前价格
     */
    private boolean currentPrice;
    /**
     * 前几
     */
    private int top;

    public boolean getWordCount() {
        return wordCount;
    }

    public void setWordCount(boolean wordCount) {
        this.wordCount = wordCount;
    }

    public boolean getRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public boolean getComments() {
        return comments;
    }

    public void setComments(boolean comments) {
        this.comments = comments;
    }

    public boolean getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(boolean currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "BasicSelectParam{" +
                "wordCount=" + wordCount +
                ", rating=" + rating +
                ", comments=" + comments +
                ", currentPrice=" + currentPrice +
                ", top=" + top +
                '}';
    }
}
