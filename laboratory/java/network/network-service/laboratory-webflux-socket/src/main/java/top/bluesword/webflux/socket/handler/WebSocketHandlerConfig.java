package top.bluesword.webflux.socket.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
class WebSocketHandlerConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        int order = -1;
        Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/send", new SendWebSocketHandler());
        map.put("/receive", new ReceiveWebSocketHandler());
        map.put("/sendAndReceive", new SendAndReceiveWebSocketHandler());
        return new SimpleUrlHandlerMapping(map, order);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
