package top.bluesword.webflux.socket.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import top.bluesword.webflux.socket.WebSocketSessionAssistant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class ImWebSocketHandler implements WebSocketHandler {

    private final Map<String,FluxSink<String>> queues = new HashMap<>();

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        String address = WebSocketSessionAssistant.getHostAddress(session);

        Flux<String> source = Flux.create(sink -> emitted(sink,address));
        Mono<Void> output = session.send(source.map(session::textMessage));
        Mono<Void> input = session.receive().doOnNext(message -> consume(message,address)).then();
        return Mono.zip(input,output).then();
    }

    private void emitted(FluxSink<String> fluxSink,String address) {
        queues.put(address,fluxSink);
    }

    private void consume(WebSocketMessage message,String address) {
        String targetAddress = message.getPayloadAsText();
        FluxSink<String> fluxSink = queues.get(targetAddress);
        if (Objects.isNull(fluxSink)) {
            FluxSink<String> reqSink = queues.get(address);
            reqSink.next("对方不在线："+targetAddress);
            return;
        }
        fluxSink.next(targetAddress);
    }

}
