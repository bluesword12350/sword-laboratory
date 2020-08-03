package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

class ZonedDateTimeTest {

    @Test
    void test() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.toString());
    }
}
