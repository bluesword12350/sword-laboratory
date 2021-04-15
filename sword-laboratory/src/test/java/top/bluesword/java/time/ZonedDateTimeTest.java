package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class ZonedDateTimeTest {

    @Test
    void now() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

    @Test
    void format() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
        System.out.println(ZonedDateTime.now().format(dateTimeFormatter));
    }

    @Test
    void parse() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2021-04-13T16:02:42+0800", dateTimeFormatter);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getOffset());
    }

}
