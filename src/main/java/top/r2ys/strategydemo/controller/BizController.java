package top.r2ys.strategydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.r2ys.strategydemo.entity.BizDto;
import top.r2ys.strategydemo.service.IBizService;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 14:20
 */
@RestController
public class BizController {

    private final IBizService bizService;

    @Autowired
    public BizController(IBizService bizService) {
        this.bizService = bizService;
    }

    @RequestMapping("/apply/{type}/{data}")
    public String apply(@PathVariable("type") String type,
                        @PathVariable("data") String data) {
        return bizService.handleBiz(new BizDto(type, data));
    }

}
