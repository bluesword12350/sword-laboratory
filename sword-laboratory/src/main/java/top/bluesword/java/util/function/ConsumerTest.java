package top.bluesword.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author 李林峰
 */
class ConsumerTest {

    @Test
    void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("1");
        sList.add("2");
        sList.add("3");
        sList.add("4");
        sList.add("5");
        printList(sList);
    }

    private void printList(List<String> strings) {
        forEach(System.out::print, strings);
    }

    private <T> void forEach(Consumer<? super T> action, List<T> strings) {
        Objects.requireNonNull(action);
        for (T t : strings) {
            action.accept(t);
        }
    }
}
