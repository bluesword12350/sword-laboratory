package com.google.common.collect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListsTest {
    @Test
    void mainTest(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        System.out.println(integers.getClass());
    }
}