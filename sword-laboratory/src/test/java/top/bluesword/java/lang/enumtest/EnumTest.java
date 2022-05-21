package top.bluesword.java.lang.enumtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumTest {

	@Test
	void valueOf() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> DemoEnum.valueOf("1"));
	}

	@Test
	void enumValue() {
		DemoEnum one = DemoEnum.ONE;
		Assertions.assertEquals("一",one.getName());
		one.setName("1");
		Assertions.assertEquals("1",one.getName());
	}

}