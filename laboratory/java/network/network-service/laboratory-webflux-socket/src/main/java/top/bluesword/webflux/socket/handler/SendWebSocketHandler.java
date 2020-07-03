package top.bluesword.webflux.socket.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 李林峰
 */
public class SendWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<String> source = Flux.just("Hello", "World") ;
        return session.send(source.map(session::textMessage));
    }

}
