package com.sun.jna;

/**
 * @author 李林峰
 */
public interface GoLibrary extends Library{
    GoLibrary INSTANCE = Native.load("GoLibrary", GoLibrary.class);

    int sum(int a, int b);

    String json(String msg);
}