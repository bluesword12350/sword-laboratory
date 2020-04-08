package top.bluesword.java.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class BigDecimalTest {

	@Test
	void setScale() {
		BigDecimal decimal = new BigDecimal("100000.215");
		BigDecimal newDecimal = decimal.setScale(2,RoundingMode.HALF_UP);
		System.out.println(newDecimal);
	}

	@Test
	void divide() {
		System.out.println(BigDecimal.ONE.divide(BigDecimal.valueOf(3),5,RoundingMode.HALF_UP));
	}

    @Test
    void equals() {
        System.out.println(BigDecimal.ZERO.equals(BigDecimal.valueOf(0.0000)));
    }

    @Test
    void compareTo() {
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.0000)));
        System.out.println(BigDecimal.valueOf(0.0000).compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.0001)));
        System.out.println(BigDecimal.valueOf(0.0001).compareTo(BigDecimal.ZERO));
    }

	@Test
	void multiply() {
		BigDecimal decimal = BigDecimal.ONE.divide(BigDecimal.valueOf(3), 5, RoundingMode.HALF_UP);
		System.out.println(decimal.multiply(decimal));
	}
}