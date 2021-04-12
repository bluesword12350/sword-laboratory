package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(28800)));
    }

}
