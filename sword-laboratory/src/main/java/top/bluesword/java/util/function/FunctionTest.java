package top.bluesword.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

class FunctionTest {

    @Test
    void apply() {
        System.out.println(apply(a -> a + 3));
    }

    private static Integer apply(Function<Integer,Integer> action) {
        return action.apply(5);
    }

}
