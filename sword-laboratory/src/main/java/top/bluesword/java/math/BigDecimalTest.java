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
	void multiply() {
		BigDecimal decimal = BigDecimal.ONE.divide(BigDecimal.valueOf(3), 5, RoundingMode.HALF_UP);
		System.out.println(decimal.multiply(decimal));
	}
}