package top.bluesword.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CharacterTest {

    @Test
    void charTest(){
        for (char i = 33; i <= 126; i++) {
            log.info("char:{} int:{}",i,(int)i);
        }
    }
}
