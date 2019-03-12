package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.List;

class ListTest {
    @Test
    void ofTest(){
        List<Integer> list = List.of(1);
        System.out.println(list.getClass());
    }
}