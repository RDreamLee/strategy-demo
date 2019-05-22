package top.r2ys.strategydemo.handler;

import top.r2ys.strategydemo.dto.BizDto;
import top.r2ys.strategydemo.service.IHandleDelegate;
import top.r2ys.strategydemo.service.IInvokeExternalSystemService;
import top.r2ys.strategydemo.service.ISourceStorageService;
import top.r2ys.strategydemo.service.IValidateService;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:33
 */
public abstract class AbstractBizHandler<T extends BizDto> implements IHandleDelegate, IValidateService, ISourceStorageService, IInvokeExternalSystemService {

    public String setup(T entity) {
        if (this.needValidate()) {
            this.validateParams(entity);
        }
        if (this.needStorageSource()) {
            this.storage(entity);
        }
        if (this.needInvokeExternal()) {
            this.req(entity);
        }
        return this.handle(entity);
    }

    abstract public String handle(T entity);

    @Override
    public boolean needValidate() {
        return false;
    }

    @Override
    public boolean needStorageSource() {
        return false;
    }

    @Override
    public boolean needInvokeExternal() {
        return false;
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
