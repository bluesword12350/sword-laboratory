package de.mkammerer.argon2;

import org.junit.jupiter.api.Test;

class Argon2Test {
    
    @Test
    void argon2hashTest(){
        Argon2 argon2 = Argon2Factory.create();
        char[] password = "12345".toCharArray();
        String hash = argon2.hash(5, 1024, 1, password);
        System.out.println(hash);
    }

    @Test
    void argon2verifyTest(){
        Argon2 argon2 = Argon2Factory.create();
        String hash = "$argon2i$v=19$m=1024,t=5,p=1$1J4ClzTn89L1D7L9LqWO/A$Yl4WSBFOFLeGGfWqCrIYUa7TDAVFigCxBav4KQ0QXTw";
        char[] password = "12345".toCharArray();
        System.out.println(argon2.verify(hash, password));
    }

    @Test
    void argon2wipeArrayTest(){
        Argon2 argon2 = Argon2Factory.create();
        char[] password = "12345".toCharArray();
        argon2.wipeArray(password);
        String hash = "$argon2i$v=19$m=1024,t=5,p=1$1J4ClzTn89L1D7L9LqWO/A$Yl4WSBFOFLeGGfWqCrIYUa7TDAVFigCxBav4KQ0QXTw";
        System.out.println(argon2.verify(hash, password));
    }
}