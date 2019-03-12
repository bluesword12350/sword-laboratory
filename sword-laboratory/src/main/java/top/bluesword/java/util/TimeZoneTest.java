package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.TimeZone;

/**
 * @author 李林峰
 */
public class TimeZoneTest {

    @Test
    void test(){
        for (String id : TimeZone.getAvailableIDs()) {
            System.out.println(id);
        }
    }
}
