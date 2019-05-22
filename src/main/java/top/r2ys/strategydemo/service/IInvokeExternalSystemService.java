package top.r2ys.strategydemo.service;

/**
 * @program: strategy-demo
 * @description: 调用外部的逻辑：映射请求实体、调用外部接口
 * @author: HU
 * @create: 2019-05-22 16:09
 */
public interface IInvokeExternalSystemService<T, U> {

    U mapFrom(T entity);

    String req(U reqParam);
}
