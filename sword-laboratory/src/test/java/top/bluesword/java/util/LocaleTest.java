package top.bluesword.java.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class LocaleTest {
    @Test
    void equals(){
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        Assertions.assertNotEquals(locale, new Locale("zh_CN"));
        Assertions.assertNotEquals(locale, new Locale("zh"));
        Assertions.assertEquals(locale, new Locale("zh","CN"));
    }

    @Test
    void toStr(){
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        System.out.println(locale);
    }

    @Test
    void toLanguageTag(){
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        System.out.println(locale.toLanguageTag());
    }

}
