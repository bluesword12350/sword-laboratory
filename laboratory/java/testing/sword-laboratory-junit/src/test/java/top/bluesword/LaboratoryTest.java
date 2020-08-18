package top.bluesword;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaboratoryTest {

    @Test
    void print(){
        int anInt = new Random().nextInt(2);
        assertTrue(anInt<2);
    }

}
