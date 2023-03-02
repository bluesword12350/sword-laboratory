package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BooleanTest {

    @Test
    void ifNull() {
        assertThrows(NullPointerException.class,this::ifWhenNull);
    }

    private void ifWhenNull() {
        Boolean[] bs = new Boolean[]{true,null};
        for (Boolean b : bs) {
            if(b){
                System.out.println();
            }
        }
    }

    @Test
    void xor() {
        Random random = new Random();
        boolean a = random.nextBoolean();
        boolean b = random.nextBoolean();
        System.out.printf("a:%b b:%b ^:%b",a,b,a^b);
    }

}
