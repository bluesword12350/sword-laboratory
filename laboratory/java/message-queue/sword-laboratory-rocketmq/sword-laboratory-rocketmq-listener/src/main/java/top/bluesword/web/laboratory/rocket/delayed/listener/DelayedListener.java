package top.bluesword.web.laboratory.rocket.delayed.listener;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 李林峰
 */
@Component
@RocketMQMessageListener(topic = "delay-abc",consumerGroup = "swordGroup")
public class DelayedListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("queue.delay:{" + message+","+"接收时间："+
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date())+'}');
    }
}