package top.r2ys.strategydemo.handler;

import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.dto.BizDto;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:47
 */
@Component
@BizType(BizEnum.BIZC)
public class BizCHandler extends AbstractBizHandler {
    @Override
    public String handle(BizDto entity) {
        return "BizCHandler succeed," + entity.getBizType() + ":" + entity.getBizData();
    }
}
