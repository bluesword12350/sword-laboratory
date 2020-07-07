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
public class SendOrReceiveWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Mono<Void> input = session.receive()
                .doOnNext(msg -> log.info(msg.getPayloadAsText()))
                .then();
        Flux<String> source = Flux.just("Hello", "World") ;
        Mono<Void> output = session.send(source.map(session::textMessage));
        return Mono.zip(input, output).then();
    }

}
