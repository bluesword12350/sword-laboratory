package org.apache.commons.lang3.time;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @author 李林峰
 */
class DurationFormatUtilsTest {
    @Test
    void main(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1994,Calendar.JUNE,30);
        System.out.println(DurationFormatUtils.formatPeriod(calendar.getTime().getTime(),
                System.currentTimeMillis(),"yy年MM月dd日"));
    }
}
