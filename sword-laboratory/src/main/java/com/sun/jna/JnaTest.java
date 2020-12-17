package com.sun.jna;

/**
 * @author 李林峰
 */
public class JnaTest {

    public static void mainTest(){
        System.out.println(GoLibrary.INSTANCE.sum(1, 2));
    }

    public static void stringTest(){
        System.out.println(GoLibrary.INSTANCE.json("llf"));
    }

    public static void main(String[] args) {
        mainTest();
        stringTest();
    }
}