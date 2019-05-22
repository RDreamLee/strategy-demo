package top.r2ys.strategydemo.handler;

import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.dto.BizDto;
import top.r2ys.strategydemo.service.IInvokeExternalSystemService;
import top.r2ys.strategydemo.service.ISourceStorageService;
import top.r2ys.strategydemo.service.IValidateService;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:47
 */
@Component
@BizType(BizEnum.BIZA)
public class BizAHandler extends AbstractBizHandler {

    @Override
    public String handle(BizDto entity) {
        return "BizAHandler succeed," + entity.getBizType() + ":" + entity.getBizData();
    }

    @Override
    public boolean needValidate() {
        return true;
    }

    @Override
    public boolean needStorageSource() {
        return true;
    }

    @Override
    public boolean needInvokeExternal() {
        return true;
    }

    @Override
    public Object req(Object reqParam) {
        return null;
    }

    @Override
    public boolean storage(Object record) {
        return false;
    }

    @Override
    public boolean validateParams(Object params) {
        return false;
    }
}
