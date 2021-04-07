package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {

    @Test
    void test() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(now, now.plusDays(-1));
        System.out.println(period.getDays());
    }
}
