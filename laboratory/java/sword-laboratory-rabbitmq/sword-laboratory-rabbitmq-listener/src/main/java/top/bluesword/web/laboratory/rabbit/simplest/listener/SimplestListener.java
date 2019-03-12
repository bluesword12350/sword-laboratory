package top.bluesword.web.laboratory.rabbit.simplest.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "simplest")
public class SimplestListener {

    @RabbitHandler
    public void process(String context) {
        System.out.println(context);
    }

}