package top.bluesword.java.time.format;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeFormatterTest {

    @Test
    void format(){
        LocalDateTime now = LocalDateTime.now();
        System.out.printf("BASIC_ISO_DATE:%S%n", DateTimeFormatter.BASIC_ISO_DATE.format(now));
        System.out.printf("ISO_DATE:%S%n",DateTimeFormatter.ISO_DATE.format(now));
        System.out.printf("ISO_DATE_TIME:%S%n",DateTimeFormatter.ISO_DATE_TIME.format(now));
        System.out.printf("ISO_LOCAL_DATE:%S%n",DateTimeFormatter.ISO_LOCAL_DATE.format(now));
        System.out.printf("ISO_LOCAL_DATE_TIME:%S%n",DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now));
    }

}
