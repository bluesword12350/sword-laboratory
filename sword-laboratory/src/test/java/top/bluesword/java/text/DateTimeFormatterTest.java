package top.bluesword.java.text;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

@Slf4j
class DateTimeFormatterTest {

    @Test
    void format(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZ").withZone(ZoneId.systemDefault());
        log.info("format:{}",dateTimeFormatter.format(Instant.now()));
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

    @Test
    void parse(){
        DateTimeFormatter dateTimeFormatter = 
                new DateTimeFormatterBuilder()
                        .appendPattern("[yyyy][yy][-][/][MM][M][-][/][dd][d][ HH:mm]")
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT)
                        .withZone(ZoneId.systemDefault());
        log.info("parse 1 :{}",ZonedDateTime.from(dateTimeFormatter.parse("2022-12-09 15:29")));
        log.info("parse 2 :{}",ZonedDateTime.from(dateTimeFormatter.parse("2022-12-09")));
        log.info("parse 3 :{}",ZonedDateTime.from(dateTimeFormatter.parse("2022/12/09")));
        log.info("parse 4 :{}",ZonedDateTime.from(dateTimeFormatter.parse("22/1/9")));
    }

}
