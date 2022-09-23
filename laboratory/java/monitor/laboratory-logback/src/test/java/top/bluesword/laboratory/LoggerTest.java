package top.bluesword.laboratory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LoggerTest {

    @Test
    void test(){
        log.info("info 日志");
        log.debug("debug日志");
    }

}
