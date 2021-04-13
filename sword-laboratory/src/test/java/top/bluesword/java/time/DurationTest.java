package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;

public class DurationTest {

    @Test
    void between() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zonedDateTime = now.plusDays(-500);
        Duration between = Duration.between(now, zonedDateTime);
        System.out.println(between);
    }
}
