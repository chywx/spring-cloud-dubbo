package cn.chendahai.lucky.web.controller;

import cn.chendahai.entity.ErrorLog;
import cn.chendahai.service.ErrorLogService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/index")
public class IndexController {


    @DubboReference
    private ErrorLogService errorLogService;


    @GetMapping("/bbb")
    public String bbb() throws ExecutionException, InterruptedException {
        System.out.println("enter bbb");

        List<CompletableFuture> list = new ArrayList<>();

        String result = errorLogService.sendMsg(new ErrorLog().setName("error"));
        // 异步调用，肯定为null
        System.out.println("result:" + result);

        list.add(RpcContext.getContext().getCompletableFuture());
        Object o = RpcContext.getContext().getFuture().get();
        System.out.println(o);

        String result2 = errorLogService.sendMsg(new ErrorLog().setName("error2"));
        System.out.println("result2:" + result2);

        list.add(RpcContext.getContext().getCompletableFuture());
        Object o2 = RpcContext.getContext().getFuture().get();
        System.out.println(o2);

        for (CompletableFuture completableFuture : list) {
            Object oo = completableFuture.get();
            System.out.println("completableFuture:" + oo);
        }
        return "bbb";
    }

    @GetMapping("/ccc")
    public void ccc() {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setName("dahai");
        errorLogService.asyncSendMsg(errorLog);
        System.out.println(123);
    }


}
