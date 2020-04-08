package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class DateTimeFormatterTest {

    @Test
    void test(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZ").withZone(ZoneId.systemDefault());
        System.out.println(dateTimeFormatter.format(Instant.now()));
    }

}
