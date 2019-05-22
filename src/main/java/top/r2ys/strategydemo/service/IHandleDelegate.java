package top.r2ys.strategydemo.service;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 16:18
 */
public interface IHandleDelegate {

    boolean needValidate();

    boolean needStorageSource();

    boolean needInvokeExternal();
}
