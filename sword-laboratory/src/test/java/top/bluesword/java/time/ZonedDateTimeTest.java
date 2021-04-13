package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class ZonedDateTimeTest {

    @Test
    void now() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.toString());
    }

    @Test
    void format() {
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZ")));
    }
}
