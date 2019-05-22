package top.r2ys.strategydemo.service;

/**
 * @program: strategy-demo
 * @description: 代理接口，是否需要校验参数、存储原始数据、调用外部
 * @author: HU
 * @create: 2019-05-22 16:18
 */
public interface IHandleDelegate {

    boolean needValidate();

    boolean needStorageSource();

    boolean needInvokeExternal();
}
