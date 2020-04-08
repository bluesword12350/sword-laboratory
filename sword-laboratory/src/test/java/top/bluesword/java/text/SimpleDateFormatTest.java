package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class SimpleDateFormatTest {

    @Test
    void formatTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ZZ");
        System.out.println(simpleDateFormat.format(new Date()));
    }

}
