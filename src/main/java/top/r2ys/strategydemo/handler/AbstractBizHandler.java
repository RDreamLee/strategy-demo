package top.r2ys.strategydemo.handler;

import top.r2ys.strategydemo.entity.BizDto;
import top.r2ys.strategydemo.exception.ValidationFailException;
import top.r2ys.strategydemo.service.*;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:33
 */
public abstract class AbstractBizHandler<S, T, U>
        implements
        IHandleDelegate,
        IParseService<S>,
        IValidateService<S>,
        ISourceStorageService<S, T>,
        IInvokeExternalSystemService<T, U> {

    public String handle(BizDto dto) throws RuntimeException {
        S raw = this.parse(dto.getBizData());
        T entity = null;
        U reqBody = null;
        String externalResponse = null;

        if (this.needValidate()) {
            this.validate(raw);
        }
        if (this.needStorageSource()) {
            entity = this.storage(raw);
        }
        if (this.needInvokeExternal()) {
            reqBody = this.mapFrom(entity);
            externalResponse = this.req(reqBody);
        }
        return externalResponse;
    }

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
    public S parse(String dataString) {
        return null;
    }

    @Override
    public boolean validate(S srcEntity) throws ValidationFailException {
        return true;
    }

    @Override
    public T storage(S record) {
        return null;
    }

    @Override
    public U mapFrom(T entity) {
        return null;
    }

    @Override
    public String req(U reqParam) {
        return null;
    }
}
