package top.bluesword.java.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

@Slf4j
class ZonedDateTimeTest {

    @Test
    void now() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

    @Test
    void isBefore() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.plusNanos(-1).isBefore(now));
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

    @Test
    void weekOfYear() {
        System.out.println(ZonedDateTime.now().get(WeekFields.ISO.weekOfYear()));
    }

    @Test
    void ofLocalDate(){
        LocalDate localDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse("2023-01-01"));
        Instant instant = ZonedDateTime.of(localDate, LocalTime.of(0, 0), ZoneId.of("+07:00")).toInstant();
        log.info("instant:{}",instant);
    }

}
