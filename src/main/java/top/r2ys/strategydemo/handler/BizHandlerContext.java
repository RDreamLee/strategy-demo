package top.r2ys.strategydemo.handler;

import top.r2ys.strategydemo.util.BeanTool;

import java.util.Map;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:35
 */
public class BizHandlerContext {

    private Map<String, Class> handlerMap;

    public BizHandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractBizHandler getInstance(String key) {
        Class clazz = handlerMap.get(key);
        if (clazz == null) {
            throw new IllegalArgumentException("handler not found for type:" + key);
        }
        AbstractBizHandler bizHandler = (AbstractBizHandler)BeanTool.getBean(clazz);
        return bizHandler;
    }
}
