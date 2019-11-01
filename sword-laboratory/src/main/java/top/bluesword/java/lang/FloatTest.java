package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author 李林峰
 */
class FloatTest {

    @Test
    void toBinaryString(){
        float value = new Random().nextFloat();
        String binaryString = Long.toBinaryString(Float.floatToIntBits(value));
        binaryString = String.format("%0"+(32-binaryString.length())+"d%s",0,binaryString);
        System.out.println(value);
        System.out.println(binaryString);
        System.out.println("============sign============");
        System.out.println(binaryString.substring(0, 1));
        System.out.println("============biased exponent============");
        System.out.println(binaryString.substring(1,9));
        System.out.println("============fraction============");
        System.out.println(binaryString.substring(9));
    }

}
