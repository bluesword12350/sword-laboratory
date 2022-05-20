package top.bluesword.laboratory.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李林峰
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level logger(){
        return Logger.Level.FULL;
    }

}
