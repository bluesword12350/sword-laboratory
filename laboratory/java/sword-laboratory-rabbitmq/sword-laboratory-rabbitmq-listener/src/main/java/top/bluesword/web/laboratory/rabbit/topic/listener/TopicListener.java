package top.bluesword.web.laboratory.rabbit.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
public class TopicListener {

    @RabbitListener(queues = "q1")
    public void message(String message) {
        System.out.println("q1  : " + message);
    }

}