package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class LocalDateTest {

    @Test
    void test(){
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(1, ChronoUnit.DAYS));
    }

}
