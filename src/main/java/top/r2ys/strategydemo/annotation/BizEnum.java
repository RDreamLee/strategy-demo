package top.r2ys.strategydemo.annotation;

/**
 * @program: strategy-demo
 * @description: enum面向的是必须要分开处理的流程，比如统一接口调用流程和文件传输流程，
 * 添加的必要条件1：必须新增一个流程才能满足
 * 添加的必要条件2：每一个流程差异化严重，必须分开才能清晰地表示逻辑
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
