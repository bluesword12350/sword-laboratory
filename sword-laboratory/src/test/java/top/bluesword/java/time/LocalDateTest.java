package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class LocalDateTest {

    @Test
    void plus(){
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(1, ChronoUnit.DAYS));
    }

    @Test
    void format(){
        String now = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(now);
    }

}
