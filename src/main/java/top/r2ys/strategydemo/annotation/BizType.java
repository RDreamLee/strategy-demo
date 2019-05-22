package top.r2ys.strategydemo.annotation;

import java.lang.annotation.*;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BizType {

    BizEnum value();
}
