package top.r2ys.strategydemo.service;

import top.r2ys.strategydemo.exception.ValidationFailException;

/**
 * @program: strategy-demo
 * @description: 负责校验原始报文实体
 * @author: HU
 * @create: 2019-05-22 16:07
 */
public interface IValidateService<S> {

    boolean validate(S srcEntity) throws ValidationFailException;
}
