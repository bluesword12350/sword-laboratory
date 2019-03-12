package top.bluesword.web.laboratory.rabbit.delayed.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
public class DelayedSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void delayedSender(String context,long millisecond) {
        rabbitTemplate.convertAndSend("delay_exchange", "delay.abc", context, message -> {
            message.getMessageProperties().setHeader("x-delay",millisecond);
            return message;
        });
    }
}