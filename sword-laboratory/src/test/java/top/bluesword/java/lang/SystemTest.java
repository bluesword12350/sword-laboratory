package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

class SystemTest {

    @Test
    void arrayCopy(){
        BigDecimal[][] line = new BigDecimal[][]{{BigDecimal.ONE,BigDecimal.TEN}};
        var routeLine = new BigDecimal[][]{{BigDecimal.TEN,BigDecimal.ONE},{BigDecimal.ONE,BigDecimal.ONE}};
        final BigDecimal[][] joinedArray = new BigDecimal[line.length+routeLine.length][2];
        System.arraycopy(line, 0, joinedArray, 0, line.length);
        System.arraycopy(routeLine, 0, joinedArray, line.length, joinedArray.length);
        System.out.println(Arrays.deepToString(joinedArray));
    }
}
