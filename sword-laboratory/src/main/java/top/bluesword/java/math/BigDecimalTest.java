package top.bluesword.java.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal decimal = new BigDecimal("100000.215");
		BigDecimal setScale = decimal.setScale(2,RoundingMode.HALF_UP);
		System.out.println(setScale);
	}
}