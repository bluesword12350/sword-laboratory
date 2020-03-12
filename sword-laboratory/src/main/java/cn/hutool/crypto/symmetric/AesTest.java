package cn.hutool.crypto.symmetric;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class AesTest {

    @Test
    void base() {
        AES aes = new AES();
        byte[] decrypt = aes.decrypt(aes.encrypt("123"));
        System.out.println(new String(decrypt, StandardCharsets.UTF_8));
    }

}
