package top.bluesword.web.laboratory.rabbit.simplest.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimplestSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void simplestSend(String context) {
        rabbitTemplate.convertAndSend("simplest", context);
    }
}