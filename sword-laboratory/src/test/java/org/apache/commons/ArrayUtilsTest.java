package org.apache.commons;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author 李林峰
 */
class ArrayUtilsTest {

    @Test
    void addAll(){
        BigDecimal[][] line = new BigDecimal[][]{};
        var routeLine = new BigDecimal[][]{{BigDecimal.TEN,BigDecimal.ONE}};
        ArrayUtils.addAll(line,routeLine);
        System.out.println(Arrays.deepToString(line));
    }
}
