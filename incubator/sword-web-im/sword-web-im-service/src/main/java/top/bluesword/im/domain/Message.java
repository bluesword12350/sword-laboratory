package top.bluesword.im.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.FluxSink;
import top.bluesword.im.util.JsonUtil;

import java.net.InetSocketAddress;

/**
 * @author 李林峰
 */
@Slf4j
@Data
public class Message {

    private MessageType type;

    private String originAddress;

    private String targetAddress;

    public void consume(InetSocketAddress address){
        this.originAddress = address.toString();
        FluxSink<String> messageQueue = MessageQueueManager.getMessageQueue(this.getTargetAddress());
        messageQueue.next(JsonUtil.toJson(this));
    }
}
