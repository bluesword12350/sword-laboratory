package cn.hutool.crypto.digest;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class MD5Test {

    @Test
    void digestHex() {
        MD5 md5 = MD5.create();
        String s = md5.digestHex("73.25", StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
