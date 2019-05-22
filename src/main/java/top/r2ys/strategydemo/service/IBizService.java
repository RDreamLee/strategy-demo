package top.r2ys.strategydemo.service;

import top.r2ys.strategydemo.entity.BizDto;

/**
 * @program: strategy-demo
 * @description: 统一的业务逻辑处理接口
 * @author: HU
 * @create: 2019-05-22 14:16
 */
public interface IBizService {

    String handleBiz(BizDto bizDto);
}
