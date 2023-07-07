package cn.chendahai.gateway;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.util.Properties;

public class NamingExample {

    public static void main(String[] args) throws NacosException {

        Properties properties = new Properties();
        properties.setProperty("serverAddr", "192.16.8.201:8848");
//        properties.setProperty("namespace", System.getProperty("namespace"));

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("chy-websocket", "192.16.21.102", 8099, "TEST1");

//        naming.registerInstance("chy-websocket", "2.2.2.2", 9999, "DEFAULT");

        System.out.println(naming.getAllInstances("chy-websocket"));

//        naming.deregisterInstance("chy-websocket", "2.2.2.2", 9999, "DEFAULT");

//        System.out.println(naming.getAllInstances("chy-websocket"));

        naming.subscribe("chy-websocket", new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(((NamingEvent) event).getServiceName());
                System.out.println(((NamingEvent) event).getInstances());
            }
        });
    }

}
