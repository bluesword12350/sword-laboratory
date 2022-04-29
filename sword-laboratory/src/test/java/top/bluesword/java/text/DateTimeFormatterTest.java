package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    @Test
    void withLocale(){
        Instant instant = Instant.now();
        DateTimeFormatter dateTimeFormatter0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+08:00"));
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+00:00")).withLocale(Locale.CHINA);
        System.out.println(dateTimeFormatter0.format(instant));
        System.out.println(dateTimeFormatter1.format(instant));
    }

}
