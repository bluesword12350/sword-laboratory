package top.bluesword.web.laboratory.rocket.topic.sender;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private RocketMQTemplate rocketTemplate;

    void send(String context) {
        this.rocketTemplate.convertAndSend("topic-test-1", context);
    }
}
