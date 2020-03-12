package top.bluesword.web.laboratory.rabbit.simplest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimplestConfig {
    @Bean
    public Queue queue() {
        return new Queue("simplest");
    }
}