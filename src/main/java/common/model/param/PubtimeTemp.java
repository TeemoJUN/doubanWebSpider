package common.model.param;

public class PubtimeTemp {
    private Integer id;

    private String pubtime;

    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime == null ? null : pubtime.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}