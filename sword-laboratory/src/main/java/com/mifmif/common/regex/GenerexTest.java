package com.mifmif.common.regex;

import org.junit.jupiter.api.Test;

/**
 * @author 李林峰
 */
class GenerexTest {

    @Test
    void test(){
        System.out.println(new Generex("[\\x00-\\xff]{8,16}").random());
    }
}