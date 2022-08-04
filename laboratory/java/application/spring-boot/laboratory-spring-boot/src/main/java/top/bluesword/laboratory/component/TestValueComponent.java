package top.bluesword.laboratory.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Slf4j
@Component
public class TestValueComponent {

    public TestValueComponent(@Value("${scheduled.time-interval-second}") String value) {
        log.info("TestValueComponent value:{}",value);
    }

}
