package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class StringJoinerTest {

    @Test
    void add(){
        System.out.println(new StringJoiner(",").add("123").add("123213").add("sfdsdf"));
    }

}
