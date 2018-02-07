package common.model.vo;

public class PressView {
    private String press;

    private Integer num;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PressView{" +
                "press='" + press + '\'' +
                ", num=" + num +
                '}';
    }
}
