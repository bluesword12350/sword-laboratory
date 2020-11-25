package org.mindrot.jbcrypt;

import org.junit.jupiter.api.Test;

class BCryptTest {

    @Test
    void base() {
        String salt = BCrypt.gensalt();
        String plaintext = BCrypt.hashpw("123231", salt);
        boolean check = BCrypt.checkpw("123231", plaintext);
        System.out.println(check);
    }

    @Test
    void gensalt() {
        String salt = BCrypt.gensalt();
        System.out.println(salt);
    }

    @Test
    void hashpw() {
        String plaintext = BCrypt.hashpw("123231", "$2a$10$tFsrHySRMgrOjyO46MoZHe");
        System.out.println(plaintext);//$2a$10$tFsrHySRMgrOjyO46MoZHeh2upAiItIRNlivYxWUikXu.L0CPdSUG
    }

}
