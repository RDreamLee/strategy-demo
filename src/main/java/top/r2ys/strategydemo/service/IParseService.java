package top.r2ys.strategydemo.service;

/**
 * @program: strategy-demo
 * @description: 解析接口，负责解析原始data报文
 * @author: HU
 * @create: 2019-05-22 16:07
 */
public interface IParseService<S> {

    S parse(String dataString);
}
