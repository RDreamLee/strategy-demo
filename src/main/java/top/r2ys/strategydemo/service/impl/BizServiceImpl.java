package top.r2ys.strategydemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.r2ys.strategydemo.dto.BizDto;
import top.r2ys.strategydemo.handler.AbstractBizHandler;
import top.r2ys.strategydemo.handler.BizHandlerContext;
import top.r2ys.strategydemo.service.IBizService;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:18
 */
@Service("BizService")
public class BizServiceImpl implements IBizService {

    private final BizHandlerContext bizHandlerContext;

    @Autowired
    public BizServiceImpl(BizHandlerContext bizHandlerContext) {
        this.bizHandlerContext = bizHandlerContext;
    }

    @Override
    public String handleBiz(BizDto bizDto) {
        AbstractBizHandler handler = null;
        try {
            handler = bizHandlerContext.getInstance(bizDto.getBizType());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return handler.setup(bizDto);
    }
}
