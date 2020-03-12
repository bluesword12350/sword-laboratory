package com.lambdaworks.crypto;

import org.junit.jupiter.api.Test;

class SCryptUtilTest {

    @Test
    void sCryptUtilTest(){
        String secret = "secret";
        String hash = SCryptUtil.scrypt(secret, 1024, 8, 1);
        System.out.println(hash);
        System.out.println(SCryptUtil.check(secret, hash));
    }
}