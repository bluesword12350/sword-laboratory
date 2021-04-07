package top.bluesword.java.time.temporal;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class ChronoUnitTest {

    @Test
    void between() throws ParseException {
        Date date1 = DateUtils.parseDate("2019-04-08 08:00:00", "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd");
        Date date2 = DateUtils.parseDate("2019-04-09 08:00:00", "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd");
        System.out.println(ChronoUnit.HOURS.between(date2.toInstant(), date1.toInstant()));
    }

    @Test
    void betweenZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zonedDateTime = now.plusDays(-500);
        System.out.println(ChronoUnit.YEARS.between(zonedDateTime, now));
    }
}
