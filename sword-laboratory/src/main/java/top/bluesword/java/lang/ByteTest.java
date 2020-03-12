package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

/**
 * @author 李林峰
 */
public class ByteTest {

    @Test
    void test(){
        System.out.println((byte) 128);
        System.out.println(Long.toBinaryString(128));
        System.out.println(Long.toBinaryString((byte) 128));
    }
}
