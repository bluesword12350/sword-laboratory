package top.bluesword.java.nio;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.Arrays;

class ByteBufferTest {

    @Test
    void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(0b100000000);
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
    }
}
