package common.model.vo;

/**
 * @author wanzailin
 * @date 2017/02/5
 */
public class MaxAndMin {
    private int max;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "MaxAndMin{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }
}
