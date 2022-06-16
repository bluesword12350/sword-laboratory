package top.bluesword.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author 李林峰
 */
class SupplierTest {

    private final Random random = new Random();

    @Test
    void apply() {
        System.out.println(apply(this::print));
    }

    private boolean print(){
        System.out.println("执行");
        return random.nextBoolean();
    }

    private static boolean apply(Supplier<Boolean> action) {
        return action.get();
    }

}
