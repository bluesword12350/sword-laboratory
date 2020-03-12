package top.bluesword.web.laboratory.rabbit.delayed.listener;

import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import top.bluesword.util.exception.SwordRuntimeException;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author 李林峰
 */
@Component
public class DelayedListener {

    private Random random = new Random();

    @RabbitListener(queues = "queue.delay")
    public void message(String message, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        int i = random.nextInt(2);
        System.out.println("{tag:"+tag+",message:"+message+"}");
        if (i==0) {
            channel.basicNack(tag,false,true);
            System.out.println(message+"---随机异常");
            throw new SwordRuntimeException("随机异常");
        }
        System.out.println("queue.delay:{" + message+","+"接收时间："+
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date())+'}');
        channel.basicAck(tag,false);
    }
}