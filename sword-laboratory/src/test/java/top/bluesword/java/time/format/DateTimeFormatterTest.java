package top.bluesword.java.time.format;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeFormatterTest {

    @Test
    void format(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(String.format("BASIC_ISO_DATE:%S", DateTimeFormatter.BASIC_ISO_DATE.format(now)));
        System.out.println(String.format("ISO_DATE:%S",DateTimeFormatter.ISO_DATE.format(now)));
        System.out.println(String.format("ISO_DATE_TIME:%S",DateTimeFormatter.ISO_DATE_TIME.format(now)));
        System.out.println(String.format("ISO_LOCAL_DATE:%S",DateTimeFormatter.ISO_LOCAL_DATE.format(now)));
        System.out.println(String.format("ISO_LOCAL_DATE_TIME:%S",DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now)));
    }

}
