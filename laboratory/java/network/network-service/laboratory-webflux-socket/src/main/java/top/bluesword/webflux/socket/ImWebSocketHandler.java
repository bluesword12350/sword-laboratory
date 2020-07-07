package top.bluesword.webflux.socket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class ImWebSocketHandler implements WebSocketHandler {

    private Map<InetAddress,Flux<String>> queues = new HashMap<>();

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Mono<Void> input = session.receive().doOnNext(this::consume).then();
        Flux<String> source = queues.get(Objects.requireNonNull(session.getHandshakeInfo().getRemoteAddress()).getAddress());
        if (Objects.isNull(source)) {
            //todo
        }
        Mono<Void> output = session.send(source.map(session::textMessage));
        return Mono.zip(input,output).then();
    }

    private void consume(WebSocketMessage message) {

    }

}
