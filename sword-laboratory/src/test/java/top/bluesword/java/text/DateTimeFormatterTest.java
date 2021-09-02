package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

class DateTimeFormatterTest {

    @Test
    void format(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZ").withZone(ZoneId.systemDefault());
        System.out.println(dateTimeFormatter.format(Instant.now()));
    }

    @Test
    void parseLocalTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm:ss").withZone(ZoneId.systemDefault());
        String dateStr = dateTimeFormatter.format(LocalTime.of(9, 3));
        System.out.println(dateStr);
        System.out.println(LocalTime.parse(dateStr,dateTimeFormatter));
    }

}
