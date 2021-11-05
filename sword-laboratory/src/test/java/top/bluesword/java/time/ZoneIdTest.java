package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;

public class ZoneIdTest {

    @Test
    void getOffset() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneRules rules = zoneId.getRules();
        ZoneOffset offset = rules.getOffset(Instant.now());
        System.out.println(offset.getTotalSeconds());
    }

    @Test
    void ofOffset() {
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneOffset offset = ZoneId.of(availableZoneId).getRules().getOffset(Instant.now());
            if (offset.getTotalSeconds() == 0) {
                System.out.println("UTC+00:00");
            } else {
                System.out.println(ZoneId.ofOffset("UTC",offset).getId());
            }
        }
    }

    @Test
    void normalized() {
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(ZoneId.of(availableZoneId).normalized());
        }
    }

    @Test
    void of() {
        String[] zoneIds = new String[]{"UTC+04:00", "+09:30", "GMT-5", "Z", "GMT+0"};
        for (String zoneIdName : zoneIds) {
            ZoneId zoneId = ZoneId.of(zoneIdName);
            System.out.println("zoneId                                     " + zoneId);
            System.out.println("zoneId.getId()                             " + zoneId.getId());
            ZonedDateTime now = ZonedDateTime.now();
            System.out.println("now                                        " + now);
            System.out.println("now.toInstant().atZone(zoneId)             " + now.toInstant().atZone(zoneId));
            System.out.println("zoneId.getRules().getOffset(Instant.now()) " + zoneId.getRules().getOffset(Instant.now()));
            System.out.println("-----------------");
        }
    }

    @Test
    void getAvailableZoneIds() {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }

}
