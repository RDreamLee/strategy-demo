package top.r2ys.strategydemo.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.entity.BizCDataEntity;
import top.r2ys.strategydemo.entity.BizCPo;
import top.r2ys.strategydemo.entity.BizDto;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:47
 */
@Component
@BizType(BizEnum.BIZC)
public class BizCHandler extends AbstractBizHandler<BizCDataEntity, BizCPo, JSONObject> {
    @Override
    public String handle(BizDto entity) {
        System.out.println("BizCHandler begin," + entity.getBizType() + ":" + entity.getBizData());
        return super.handle(entity);
    }
}
