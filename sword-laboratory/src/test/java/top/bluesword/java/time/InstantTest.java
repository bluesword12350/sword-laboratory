package top.bluesword.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;

/**
 * @author 李林峰
 */
class InstantTest {

    @Test
    void compareTo(){
        Instant instant = Instant.ofEpochMilli(0);
        Instant instant1 = Instant.ofEpochMilli(0);
        System.out.println(instant.compareTo(instant1));
    }

}
