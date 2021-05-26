package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {

    @Test
    void between() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(now, now.plusDays(-500));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

}
