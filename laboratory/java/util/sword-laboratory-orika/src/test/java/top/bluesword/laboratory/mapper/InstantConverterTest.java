package top.bluesword.laboratory.mapper;

import org.junit.jupiter.api.Test;

import java.time.Instant;

class InstantConverterTest {

    @Test
    void convert(){
        System.out.println(DefaultMapperUtil.map(1600000000000L, Instant.class));
    }
}