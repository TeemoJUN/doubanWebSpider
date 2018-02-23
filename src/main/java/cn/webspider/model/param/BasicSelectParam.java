package cn.webspider.model.param;

/**
 * 基本查询(根据字数，评分，评论人数，当前价格，查询top前几的书籍)
 *
 * @author wanzailin
 * @date 2018/01/14
 */

public class BasicSelectParam {
    /**
     * 字数
     */
    private boolean wordCount;
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
     * 请求的页
     */
    private int page;
    /**
     * 查询开始的地方
     */
    private int start;
    /**
     * 每页的行数
     */
    private int perPageRows;

    public int getPerPageRows() {
        return perPageRows;
    }

    public void setPerPageRows(int perPageRows) {
        this.perPageRows = perPageRows;
    }




    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        return page;
    }


    public boolean setWordCount() {
        return wordCount;
    }

    public void setPage(int page) {
        this.page = page;
    }

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

    @Override
    public String toString() {
        return "BasicSelectParam{" +
                "wordCount=" + wordCount +
                ", rating=" + rating +
                ", comments=" + comments +
                ", currentPrice=" + currentPrice +
                ", page=" + page +
                '}';
    }
}
