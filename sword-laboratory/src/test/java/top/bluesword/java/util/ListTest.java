package top.bluesword.java.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListTest {

    @Test
    void of(){
        List<Integer> list = List.of(1);
        System.out.println(list.getClass());
    }

    @Test
    void set(){
        List<Integer> list = new ArrayList<>(List.of(1,2,3));
        list.set(1,5);
        System.out.println(list);
    }

    @Test
    void remove(){
        List<String> list = new ArrayList<>(List.of("1","1","2"));
        Assertions.assertFalse(list.remove(null));
        Assertions.assertFalse(list.remove("null"));
        Assertions.assertFalse(list.remove(""));
        Assertions.assertTrue(list.remove("1"));
        System.out.println(list);
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