package cn.chendahai.log.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import cn.chendahai.entity.ErrorLog;
import cn.chendahai.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

//@Service(version = "${dubbo.version}", async = false)
@DubboService
public class ErrorLogServiceImpl implements ErrorLogService {

    @Value("${server.port}")
    private String port;

    @Value("${test.demo}")
    private String testDemo;


    @Override
    public String sendMsg(ErrorLog errorLog) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = errorLog.getName();
        System.out.println("receive：" + name);
        return "ok:" + name;
    }

    @Override
    public void asyncSendMsg(ErrorLog errorLog) {
        System.out.println("port:" + port);
        System.out.println("testDemo:" + testDemo);
        System.out.println("asyncSendMsg:" + JSONObject.toJSONString(errorLog));
    }
}
