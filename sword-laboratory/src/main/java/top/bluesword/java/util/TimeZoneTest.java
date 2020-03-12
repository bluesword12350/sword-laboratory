package top.bluesword.java.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 李林峰
 */
class TimeZoneTest {

    @Test
    void getAvailableIds(){
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
    }

    @Test
    void getTimeZone(){
        System.out.println(TimeZone.getTimeZone("-8:00"));
    }

    @Test
    void format() {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss ZZZ", TimeZone.getTimeZone("GMT+08:30")));
    }

    @Test
    void millisFormat(){
        System.out.println(DateFormatUtils.format(1573029720000L, "yyyy-MM-dd HH:mm:ss ZZZ", TimeZone.getTimeZone("GMT-08:00")));
    }
}
