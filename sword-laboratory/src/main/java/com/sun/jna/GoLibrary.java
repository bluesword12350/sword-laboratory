package com.sun.jna;

/**
 * @author 李林峰
 */
public interface GoLibrary extends Library{

    /**
     * /src/main/go/GoLibrary.go
     */
    GoLibrary INSTANCE = Native.load("GoLibrary", GoLibrary.class);

    /**
     * 加法
     * @param a 加数1
     * @param b 加数2
     * @return 和
     */
    int sum(int a, int b);

    /**
     * json处理
     * @param msg 消息
     * @return 消息返回
     */
    String json(String msg);

}