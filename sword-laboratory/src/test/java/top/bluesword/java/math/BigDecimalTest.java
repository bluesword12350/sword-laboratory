package top.bluesword.java.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
class BigDecimalTest {

	@Test
	void setScale() {
		BigDecimal decimal = new BigDecimal("100000.215");
		BigDecimal newDecimal = decimal.setScale(2,RoundingMode.HALF_UP);
		log.info("{}",newDecimal);
	}

	@Test
	void divide() {
		log.info("{}",BigDecimal.ONE.divide(BigDecimal.valueOf(3),5,RoundingMode.HALF_UP));
	}

	@Test
	void intValue() {
		int i = new BigDecimal("1.99").intValue();
		log.info("{}",i);
	}

	@Test
	void equals() {
		log.info("{}",BigDecimal.ZERO.equals(BigDecimal.valueOf(0.0000)));
	}

	@Test
	void zeroEquals() {
		log.info("{}",0 == new BigDecimal("0.00000").doubleValue());
		log.info("{}",BigDecimal.ZERO.equals(BigDecimal.valueOf(0.0000)));
		log.info("{}",BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.0000))==0);
	}

    @Test
    void compareTo() {
        log.info("{}",BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.0000)));
        log.info("{}",BigDecimal.valueOf(0.0000).compareTo(BigDecimal.ZERO));
        log.info("{}",BigDecimal.ZERO.compareTo(BigDecimal.valueOf(0.0001)));
        log.info("{}",BigDecimal.valueOf(0.0001).compareTo(BigDecimal.ZERO));
    }

	@Test
	void multiply() {
		BigDecimal decimal = BigDecimal.ONE.divide(BigDecimal.valueOf(3), 5, RoundingMode.HALF_UP);
		log.info("{}",decimal.multiply(decimal));
	}

	@Test
	void string() {
		log.info("{}",new BigDecimal("0.000000"));
	}

	@Test
	void scientificNotation() {
		log.info("P-10:{}",BigDecimal.valueOf(Math.pow(10, -10)).stripTrailingZeros().toPlainString());
		log.info("P -7:{}",new BigDecimal(new BigDecimal("1.0E-7").toPlainString()));
		log.info("  -7:{}",BigDecimal.valueOf(Math.pow(10, -7)));
		log.info("  -6:{}",BigDecimal.valueOf(Math.pow(10, -6)));
		log.info("   6:{}",BigDecimal.valueOf(Math.pow(10, 6)).stripTrailingZeros());
		log.info("   7:{}",BigDecimal.valueOf(Math.pow(10, 7)));
		BigDecimal pow10 = BigDecimal.valueOf(Math.pow(10, 10));
		log.info("  10:{}", pow10.toPlainString());
		log.info("P100:{}",new BigDecimal(BigDecimal.valueOf(Math.pow(10, 100)).toPlainString()));
	}

}
