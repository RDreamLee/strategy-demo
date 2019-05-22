package top.r2ys.strategydemo.service;

/**
 * @program: strategy-demo
 * @description: 负责持久数据
 * @author: HU
 * @create: 2019-05-22 16:08
 */
public interface ISourceStorageService<S, T> {

    T storage(S record);
}
