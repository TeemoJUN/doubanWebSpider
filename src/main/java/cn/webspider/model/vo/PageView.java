package cn.webspider.model.vo;

public class PageView {
    private int AllPage;
    private int currentPage;

    public int getAllPage() {
        return AllPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setAllPage(int allPage) {
        AllPage = allPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageView{" +
                "AllPage=" + AllPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
