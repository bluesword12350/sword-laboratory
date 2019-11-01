package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class DoubleTest {

    @Test
    void toBinaryString(){
        double value = 25;
        String binaryString = Long.toBinaryString(Double.doubleToLongBits(value));
        binaryString = String.format("%0"+(64-binaryString.length())+"d%s",0,binaryString);
        System.out.println(value);
        System.out.println(binaryString);
        System.out.println(binaryString.substring(0,1));
        System.out.println(binaryString.substring(1,11));
        System.out.println(binaryString.substring(11));
    }
}
