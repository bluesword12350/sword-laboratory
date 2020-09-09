package top.bluesword.web.laboratory.rocket.error.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
@RocketMQMessageListener(topic = "topic-test-error",consumerGroup = "swordGroup1")
public class ErrorListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println(message);
        throw new RuntimeException("主动异常");
    }
}