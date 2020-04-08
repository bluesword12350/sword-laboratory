package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

class CollectionTest {
    @Test
    void testCollectionToArray(){
        Set<String> names = Set.of("Fred", "Wilma", "Barney", "Betty");
        String[] copy = new String[names.size()];
        names.toArray(copy);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(names.toArray(String[]::new)));
    }
}
