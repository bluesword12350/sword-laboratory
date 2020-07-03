package top.bluesword.webflux.socket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 李林峰
 */
@Slf4j
public class SendAndReceiveWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> output = session.receive()
                .doOnNext(msg -> log.info(msg.getPayloadAsText()))
                .map(value -> session.textMessage("Echo " + value.getPayloadAsText()));
        return session.send(output);
    }

}
