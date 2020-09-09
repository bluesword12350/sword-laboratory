package top.bluesword.web.laboratory.rocket.delayed.sender;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 李林峰
 */
@Component
public class DelayedSender {

    @Autowired
    private RocketMQTemplate rocketTemplate;

    public void delayedSender(String context) {
        SendResult sendResult = rocketTemplate.syncSend("delay-abc",
                MessageBuilder.withPayload(context).build(),
                1000,
                2);
        System.out.println("queue.delay:{回调时间："+DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date())+'}');
    }
}