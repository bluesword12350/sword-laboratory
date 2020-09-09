package top.bluesword.web.laboratory.rocket.error.sender;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
public class ErrorSender {

    @Autowired
    private RocketMQTemplate rocketTemplate;

    void send(String context) {
        this.rocketTemplate.convertAndSend("topic-test-error", context);
    }

}
