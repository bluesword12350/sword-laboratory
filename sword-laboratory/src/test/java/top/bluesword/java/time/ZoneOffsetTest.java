package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZoneOffset;

public class ZoneOffsetTest {

    @Test
    void ofTotalSeconds() {
        System.out.println(ZoneOffset.ofTotalSeconds(28800));
    }
}
