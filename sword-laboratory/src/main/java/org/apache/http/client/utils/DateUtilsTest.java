package org.apache.http.client.utils;

import org.junit.jupiter.api.Test;

class DateUtilsTest {
    @Test
    void parseDate(){
        String fieldValue = "2019-04-08 08:00:00.0";
        System.out.println(DateUtils.parseDate(fieldValue, new String[]{"yyyy-MM-dd HH:mm:ss.S","yyyy-MM-dd"}));
    }
}
