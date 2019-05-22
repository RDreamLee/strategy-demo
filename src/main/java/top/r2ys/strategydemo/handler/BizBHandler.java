package top.r2ys.strategydemo.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.entity.BizBDataEntity;
import top.r2ys.strategydemo.entity.BizBPo;
import top.r2ys.strategydemo.entity.BizDto;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:47
 */
@Component
@BizType(BizEnum.BIZB)
public class BizBHandler extends AbstractBizHandler<BizBDataEntity, BizBPo, JSONObject> {
    @Override
    public String handle(BizDto entity) {
        System.out.println("BizBHandler begin," + entity.getBizType() + ":" + entity.getBizData());
        return super.handle(entity);
    }
}
