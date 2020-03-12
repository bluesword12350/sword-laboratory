package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class DoubleTest {

    @Test
    void toBinaryString(){
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(25)));
    }

    @Test
    void parseDouble(){
        System.out.println(Double.parseDouble("0.5"));
    }

    @Test
    void parseBinaryString(){
        double value = -100.5;
        String binaryString = Long.toBinaryString(Double.doubleToLongBits(value));
        binaryString = binaryString.length()<64?String.format("%0"+(64-binaryString.length())+"d%s",0,binaryString):binaryString;

        int decimalDigit = 12 + Integer.parseInt(binaryString.substring(1, 12), 2) - 1023;

        boolean sign = '1'== binaryString.charAt(0);
        String substring = (sign ? "-" : "" ) + "1"+ binaryString.substring(12, decimalDigit);

        double nd = Long.parseLong(substring,2);
        char[] chars = binaryString.substring(decimalDigit).toCharArray();

        double power = sign?-0.5:0.5;
        for (char c : chars) {
            if (c=='1') {
                nd+=power;
            }
            power/=2;
        }

        System.out.println(value);
        System.out.println(binaryString);
        System.out.println(nd);
    }
}
