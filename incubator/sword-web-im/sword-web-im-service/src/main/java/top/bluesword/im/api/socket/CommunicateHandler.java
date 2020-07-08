package top.bluesword.im.api.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import top.bluesword.im.domain.Message;
import top.bluesword.im.domain.MessageQueueManager;
import top.bluesword.im.domain.MessageType;
import top.bluesword.im.domain.TextMessage;
import top.bluesword.im.util.JsonUtil;
import top.bluesword.im.util.WebSocketSessionAssistant;

import java.net.InetSocketAddress;

/**
 * @author 李林峰
 */
@Slf4j
public class CommunicateHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        InetSocketAddress address = WebSocketSessionAssistant.getRemoteAddress(session);
        Flux<String> source = Flux.create(sink -> emitted(sink, address));
        Mono<Void> output = session.send(source.map(session::textMessage));
        Mono<Void> input = session.receive()
                .doOnNext(message -> consume(message, address))
                .doFinally(sig -> offline(address))
                .then();
        return Mono.zip(input, output).then();
    }

    private void offline(InetSocketAddress address) {
        MessageQueueManager.remove(address);
    }

    private void emitted(FluxSink<String> fluxSink, InetSocketAddress address) {
        MessageQueueManager.putMessageQueue(address, fluxSink);
    }

    private void consume(WebSocketMessage message, InetSocketAddress address) {
        FluxSink<String> reqSink = MessageQueueManager.getMessageQueue(address);
        String payloadAsText = message.getPayloadAsText();
        Message msg;
        try {
            msg = JsonUtil.fromJson(payloadAsText, Message.class);
        } catch (Exception e) {
            reqSink.next("消息格式错误");
            return;
        }
        String targetAddress = msg.getTargetAddress();
        if (!MessageQueueManager.contains(targetAddress)) {
            reqSink.next("对方不在线：" + targetAddress);
            return;
        }
        MessageType type = msg.getType();
        Message consumeMsg;
        if (MessageType.text.equals(type)) {
            consumeMsg = JsonUtil.fromJson(payloadAsText, TextMessage.class);
        } else {
            reqSink.next("消息类型不能为空");
            return;
        }
        consumeMsg.consume(address);
    }

}
