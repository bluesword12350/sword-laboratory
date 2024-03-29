package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CollectionsTest {

    @Test
    void addAll() {
        Integer[] a = new Integer[]{12,15,454,48,542,59};
        ArrayList<Integer> list = new ArrayList<>(a.length);
        Collections.addAll(list,a);
        System.out.println(list);
    }

    @Test
    void singletonList() {
        List<Object> list = Collections.singletonList(null);
        System.out.println(list);
    }

}
