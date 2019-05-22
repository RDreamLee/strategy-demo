package top.r2ys.strategydemo.annotation;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 15:50
 */
public enum BizEnum {
    BIZA("BIZ_A"),
    BIZB("BIZ_B"),
    BIZC("BIZ_C");

    private String type;

    BizEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
