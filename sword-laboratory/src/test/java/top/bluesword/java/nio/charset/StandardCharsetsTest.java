package top.bluesword.java.nio.charset;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

@Slf4j
public class StandardCharsetsTest {

    @Test
    void test(){
        log.info(StandardCharsets.UTF_8.name());
    }

}
