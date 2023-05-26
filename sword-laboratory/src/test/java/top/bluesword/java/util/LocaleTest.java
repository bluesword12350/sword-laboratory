package top.bluesword.java.util;

import org.apache.commons.lang3.LocaleUtils;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class LocaleTest {
    @Test
    void equals(){
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        System.out.println(locale.equals(new Locale("zh_CN")));
        System.out.println(locale.equals(new Locale("zh")));
        System.out.println(locale.equals(new Locale("zh","cn")));
        System.out.println(locale.equals(LocaleUtils.toLocale("zh_CN")));
    }

}
