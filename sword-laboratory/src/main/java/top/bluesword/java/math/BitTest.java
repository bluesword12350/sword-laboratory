package top.bluesword.java.math;

import org.junit.jupiter.api.Test;

class BitTest {

    @Test
    void test(){
        System.out.println(~(-1L << 63));

        System.out.println(Long.toBinaryString(-1L));
        System.out.println(Long.toBinaryString(-1L << 63));
        System.out.println(Long.toBinaryString(~(-1L << 63)));
        System.out.println("=======================");
        System.out.println(Long.toBinaryString(-1L));
        System.out.println(Long.toBinaryString(-1L >>> 1));
    }

}
