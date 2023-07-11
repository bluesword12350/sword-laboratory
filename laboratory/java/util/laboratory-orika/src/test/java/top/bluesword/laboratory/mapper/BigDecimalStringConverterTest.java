package top.bluesword.laboratory.mapper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BigDecimalStringConverterTest {

    @Test
    void convert(){
        System.out.println(DefaultMapperUtil.map("12.21", BigDecimal.class));
    }

}