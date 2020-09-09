package top.bluesword.web.laboratory.rocket.topic.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
@RocketMQMessageListener(topic = "topic-test-1",consumerGroup = "swordGroup0")
public class TopicListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("topic-test-1  : " + message);
    }
}