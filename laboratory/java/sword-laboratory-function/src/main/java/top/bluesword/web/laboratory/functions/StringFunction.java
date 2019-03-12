package top.bluesword.web.laboratory.functions;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author 李林峰
 */
@Component
public class StringFunction {

    @Bean
    public Function<String, String> uppercase() {
        return String::toUpperCase;
    }
}
