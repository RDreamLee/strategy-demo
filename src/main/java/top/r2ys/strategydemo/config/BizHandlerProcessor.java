package top.r2ys.strategydemo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizType;
import top.r2ys.strategydemo.handler.BizHandlerContext;
import top.r2ys.strategydemo.repository.BizTypeMapper;
import top.r2ys.strategydemo.util.ClassScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 15:03
 */
@Component
public class BizHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String BIZ_HANDLER_PACKAGE_NAME = "top.r2ys.strategydemo.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String, Class> handlerMap = new HashMap<>(BizTypeMapper.bizTypes.size());
        Set<Class<?>> clazzSet = ClassScanner.scanByAnnotations(BIZ_HANDLER_PACKAGE_NAME, BizType.class);
        clazzSet.forEach(clazz -> {
            String type = clazz.getAnnotation(BizType.class).value().getType();
            handlerMap.put(type, clazz);
        });
        BizHandlerContext handlerContext = new BizHandlerContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(BizHandlerContext.class.getName(), handlerContext);
    }
}
