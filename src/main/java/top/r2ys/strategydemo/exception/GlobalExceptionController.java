package top.r2ys.strategydemo.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program:
 * @description:
 * @author: HU
 * @create: 2019-03-28 13:24
 */
@Slf4j
@RestControllerAdvice
@Order(2)
public class GlobalExceptionController {

    @ExceptionHandler(value = {ValidationFailException.class})
    public String validationFailExceptionHandle(ValidationFailException e) {
        log.error("validationFailExceptionHandle:", e);
        return new JSONObject().fluentPut("code", "100001").fluentPut("message", e.getMessage()).toJSONString();
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public String runtimeExceptionHandle(RuntimeException e) {
        log.error("runtimeExceptionHandle:", e);
        return new JSONObject().fluentPut("code", "100002").fluentPut("message", e.getMessage()).toJSONString();
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public String illegalArgumentExceptionHandle(IllegalArgumentException e) {
        log.error("illegalArgumentExceptionHandle:", e);
        return new JSONObject().fluentPut("code", "100003").fluentPut("message", e.getMessage()).toJSONString();
    }

    @ExceptionHandler(value = {Exception.class})
    public String exceptionHandle(Exception e) {
        log.error("exceptionHandle:", e);
        return new JSONObject().fluentPut("code", "200001").fluentPut("message", e.getMessage()).toJSONString();
    }
}
