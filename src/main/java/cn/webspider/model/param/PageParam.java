package cn.webspider.model.param;

public class PageParam {
    private int Rows;

    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        Rows = rows;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "Rows=" + Rows +
                '}';
    }
}
