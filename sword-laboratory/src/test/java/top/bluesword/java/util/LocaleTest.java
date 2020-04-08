package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Locale;

class LocaleTest {
    @Test
    void mainTest(){
        Locale locale = new Locale("en","US");
        System.out.println(locale.getDisplayCountry(Locale.US));
        System.out.println(locale.getDisplayLanguage(Locale.US));
        System.out.println(locale.getDisplayName(Locale.US));
    }
}
