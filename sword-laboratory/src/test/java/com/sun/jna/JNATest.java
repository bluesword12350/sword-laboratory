package com.sun.jna;

import org.junit.jupiter.api.Test;

class JNATest{
    @Test
    void mainTest(){
        System.out.println(GoLibrary.INSTANCE.sum(1, 2));
    }

    @Test
    void stringTest(){
        System.out.println(GoLibrary.INSTANCE.json("llf"));
    }
}