package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

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
}
