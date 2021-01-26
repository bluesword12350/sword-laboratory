package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListTest {

    @Test
    void ofTest(){
        List<Integer> list = List.of(1);
        System.out.println(list.getClass());
    }

    @Test
    void getClassTest(){
        List<String> list1 = new ArrayList<>();
        list1.add("23");
        List<Integer> list2 = new ArrayList<>();
        list2.add(23);
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }

    @Test
    void sort() {
        List<String> list1 = new ArrayList<>();
        list1.add("23");
        list1.add("231");
        Comparator<String> comparing = Comparator.comparing(x -> (long) x.length());
        list1.sort(comparing.reversed());
        System.out.println(list1);
    }
}