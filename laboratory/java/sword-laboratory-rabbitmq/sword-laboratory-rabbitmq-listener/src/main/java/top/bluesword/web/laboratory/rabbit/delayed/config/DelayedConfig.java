package top.bluesword.web.laboratory.rabbit.delayed.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李林峰
 */
@Configuration
public class DelayedConfig {

    @Bean
    Queue delayQuery(){
        return new Queue("queue.delay");
    }

    @Bean
    DirectExchange  delayExchange() {
        DirectExchange directExchange = new DirectExchange("delay_exchange", true, false);
        directExchange.setDelayed(true);
        return directExchange;
    }

    @Bean
    Binding binding(Queue delayQuery,DirectExchange delayExchange) {
        return BindingBuilder.bind(delayQuery).to(delayExchange)
                .with("delay.abc");
    }
}