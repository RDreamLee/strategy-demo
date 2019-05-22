package top.r2ys.strategydemo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.r2ys.strategydemo.annotation.BizEnum;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: conductor
 * @description:
 * @author: HU
 * @create: 2019-04-24 19:03
 */
@Deprecated
@Component
public class BizTypeMapper {

    public static Map<String, Map<String, String>> bizTypes = new HashMap<>();

    @PostConstruct
    public void init() {
        BizTypeMapper.bizTypes.clear();
        BizTypeMapper.bizTypes.putAll(bizTypeMap());
    }

    @Bean
    public Map<String, Map<String, String>> bizTypeMap() {
        // TODO 从数据库或者常量配置
        List<Map<String, String>> bizTypeMapList = new ArrayList<>();

        Map<String, String> bizTypeA = new HashMap<>();
        bizTypeA.put("name", BizEnum.BIZA.getType());
        bizTypeA.put("type", "a");
        Map<String, String> bizTypeB = new HashMap<>();
        bizTypeB.put("name", BizEnum.BIZB.getType());
        bizTypeB.put("type", "b");
        Map<String, String> bizTypeC = new HashMap<>();
        bizTypeC.put("name", BizEnum.BIZC.getType());
        bizTypeC.put("type", "c");

        bizTypeMapList.add(bizTypeA);
        bizTypeMapList.add(bizTypeB);
        bizTypeMapList.add(bizTypeC);

        Map<String, Map<String, String>> result = bizTypeMapList.stream().collect(Collectors.toMap(each -> String.valueOf(each.get("name")), each -> each, (k1, k2) -> k1));
        return result;
    }

}
