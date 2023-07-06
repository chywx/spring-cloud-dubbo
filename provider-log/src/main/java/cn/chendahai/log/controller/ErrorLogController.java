package cn.chendahai.log.controller;

import cn.chendahai.log.config.DynamicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
@RefreshScope
public class ErrorLogController {

    @Autowired
    DynamicConfig dynamicConfig;

    @GetMapping("/test1")
    public String test1() {
        System.out.println("test1 dynamicConfig:" + dynamicConfig.getTestDemo());
        return "test1";
    }

}
