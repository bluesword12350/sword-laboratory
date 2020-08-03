package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class LocalDateTimeTest {

    @Test
    void test(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
    }
}
