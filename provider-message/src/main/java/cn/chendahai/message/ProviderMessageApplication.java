package cn.chendahai.message;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class ProviderMessageApplication {
//public class SeaProviderLogApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMessageApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("SeaProviderLogApplication正在启动。。。");
//        while(true) {
//            Thread.sleep(600000000);
//            System.out.println("sleep....");
//        }
//    }
}
