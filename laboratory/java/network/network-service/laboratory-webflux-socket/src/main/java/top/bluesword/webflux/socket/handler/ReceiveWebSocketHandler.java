package top.bluesword.webflux.socket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * @author 李林峰
 */
@Slf4j
public class ReceiveWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.receive()
                .doOnNext(msg -> log.info(msg.getPayloadAsText()))
                .then();
    }

}
