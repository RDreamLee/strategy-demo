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
@BizType(BizEnum.BIZB)
public class BizBHandler extends AbstractBizHandler {
    @Override
    public String handle(BizDto entity) {
        return "BizBHandler succeed," + entity.getBizType() + ":" + entity.getBizData();
    }

    @Override
    public boolean needValidate() {
        return true;
    }

    @Override
    public boolean validateParams(Object params) {
        return false;
    }
}
