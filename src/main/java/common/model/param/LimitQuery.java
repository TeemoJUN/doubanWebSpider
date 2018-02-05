package common.model.param;

/**
 * 限制查询
 * @author wanzailin
 * @date 2018/02/05
 */
public class LimitQuery {
    /**
     * 起始值
     */
    private int start;
    /**
     * 终止值
     */
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "LimitQuery{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
