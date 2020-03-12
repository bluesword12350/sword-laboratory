package top.bluesword.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * @author 李林峰
 */
class SupplierTest {

    @Test
    void apply() {
        System.out.println(apply(this::print));
    }

    private Boolean print(){
        System.out.println("执行");
        return true;
    }

    private static Boolean apply(Supplier<Boolean> action) {
        return action.get();
    }

}
