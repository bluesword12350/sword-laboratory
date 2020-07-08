package top.bluesword.webflux.socket.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

/**
 * @author 李林峰
 */
public class SendOrReceiveWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Mono<Void> input = session.receive()
                .doOnNext(msg -> System.out.println(msg.getPayloadAsText()))
                .then();
        Flux<String> source = Flux.create(this::emitted);
        Mono<Void> output = session.send(source.map(session::textMessage));
        return Mono.zip(input, output).then();
    }

    private void emitted(FluxSink<String> sink) {
        sink.next("132456");
    }

}
