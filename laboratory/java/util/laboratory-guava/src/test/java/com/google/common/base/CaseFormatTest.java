package com.google.common.base;

import org.junit.jupiter.api.Test;

class CaseFormatTest {

    @Test
    void main(){
        Converter<String, String> camelToUnderscoreConverter = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
        System.out.println(camelToUnderscoreConverter.convert("abCd"));
        System.out.println(camelToUnderscoreConverter.convert("ab_Cd"));
        System.out.println(camelToUnderscoreConverter.convert("ab_cd"));
        System.out.println(camelToUnderscoreConverter.convert("AB_CD"));
        System.out.println(camelToUnderscoreConverter.convert("ABCD"));
    }
}