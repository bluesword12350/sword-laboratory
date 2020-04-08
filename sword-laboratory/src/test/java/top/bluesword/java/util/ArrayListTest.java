package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ArrayListTest {

    @Test
    void subList() {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            aList.add(i);
        }
        int size = aList.size() / 1000;
        for (int i = 0; i < size; i++) {
            System.out.println(aList.subList(i * 1000, (i + 1) * 1000));
        }
        System.out.println(aList.subList(size*1000,aList.size()));
    }

    @Test
    void add() {
        List<String> aList = new ArrayList<>();
        aList.add("1");
        aList.add("2");
        aList.add(null);
        aList.add(3,"0");
        System.out.println(aList);
    }

    @Test
    void sort(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(1);
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list);
    }
}
