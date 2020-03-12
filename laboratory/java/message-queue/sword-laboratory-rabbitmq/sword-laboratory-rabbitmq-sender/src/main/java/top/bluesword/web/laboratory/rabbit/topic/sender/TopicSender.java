package top.bluesword.web.laboratory.rabbit.topic.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    void send(String exchange, String routingKey, String context) {
        this.rabbitTemplate.convertAndSend(exchange, routingKey, context);
    }
}
