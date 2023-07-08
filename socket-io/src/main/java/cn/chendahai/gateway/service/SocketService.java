package cn.chendahai.gateway.service;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Slf4j
@Component
public class SocketService {
    @Bean
    public SocketIOServer socketIOServer() {
        System.out.println("init socket server");

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);

        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
//        Configuration configuration = new Configure();
        configuration.setHostname("localhost");
        configuration.setPort(7878);
//        configuration.setContext("/demo");
        configuration.setSocketConfig(socketConfig);

        SocketIOServer socketIOServer = new SocketIOServer(configuration);
//        socketIOServer.start();
//        System.out.println("socket server init finish");

        return socketIOServer;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }




}
