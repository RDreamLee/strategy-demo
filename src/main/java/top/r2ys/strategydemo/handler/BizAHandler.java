package top.r2ys.strategydemo.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.entity.BizADataEntity;
import top.r2ys.strategydemo.entity.BizAPo;
import top.r2ys.strategydemo.entity.BizDto;
import top.r2ys.strategydemo.exception.ValidationFailException;

import java.time.LocalDate;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:47
 */
@Component
@BizType(BizEnum.BIZA)
public class BizAHandler extends AbstractBizHandler<BizADataEntity, BizAPo, JSONObject> {

    @Override
    public String handle(BizDto entity) {
        System.out.println("BizAHandler begin," + entity.getBizType() + ":" + entity.getBizData());
        return super.handle(entity);
    }

    @Override
    public BizADataEntity parse(String dataString) {
        BizADataEntity bizADataEntity = JSONObject.parseObject(dataString, BizADataEntity.class);
        System.out.println("parsed:" + bizADataEntity.toString());
        return bizADataEntity;
    }

    @Override
    public boolean needValidate() {
        System.out.println("needValidate:" + "true");
        return true;
    }

    @Override
    public boolean validate(BizADataEntity srcEntity) throws ValidationFailException {
        if (StringUtils.isBlank(srcEntity.getFieldI()) || srcEntity.getFieldI().contains("fuck")) {
            throw new ValidationFailException("fieldI isblank or contains fuck");
        }
        System.out.println("validate succeed");
        return true;
    }

    @Override
    public boolean needStorageSource() {
        System.out.println("needStorageSource:" + "true");
        return true;
    }

    @Override
    public BizAPo storage(BizADataEntity record) {
        BizAPo po = new BizAPo("columnI_" + record.getFieldI());
        System.out.printf("saved into database:" + po.toString());
        return po;
    }

    @Override
    public boolean needInvokeExternal() {
        System.out.println("needInvokeExternal:" + "true");
        return true;
    }

    @Override
    public JSONObject mapFrom(BizAPo entity) {
        JSONObject reqParam = new JSONObject();
        reqParam.put("time", LocalDate.now().toString());
        reqParam.put("data", entity.getColumnI() + "-" + RandomStringUtils.randomAlphabetic(5));
        System.out.printf("mapped:" + reqParam.toJSONString());
        return reqParam;
    }

    @Override
    public String req(JSONObject reqParam) {
        String response = mockPostRequest("http://8.8.8.8:20000/api", reqParam.toJSONString());
        return response;
    }

    private String mockPostRequest(String url, String param) {
        return "invoke succeed";
    }
}
