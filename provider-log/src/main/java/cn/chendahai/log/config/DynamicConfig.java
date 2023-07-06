package cn.chendahai.log.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@Data
public class DynamicConfig {

    @Value("${test.demo}")
    private String testDemo;

}
