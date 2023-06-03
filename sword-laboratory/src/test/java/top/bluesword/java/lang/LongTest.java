package top.bluesword.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class LongTest {

	@Test
	void parseLong() {
		long parseInt = Long.parseLong("-AB",16);
		System.out.println(parseInt);
		String string = Long.toString(parseInt, 36);
		System.out.println(string);
	}

	@Test
	void valueOf(){
		System.out.println(Long.valueOf("4"));
	}

	@Test
	void toBinaryString(){
		System.out.println(Long.toBinaryString(1));
		System.out.println(Long.toBinaryString(3));

		String binaryString = Long.toBinaryString(~(-1L << 63));
		System.out.println(binaryString);
		System.out.println(binaryString.length());

		String time = Long.toBinaryString(System.currentTimeMillis()/1000);
		System.out.println(time);
		System.out.println(time.length());

		String binaryString2 = Long.toBinaryString(~(-1L << 63));
		System.out.println(binaryString2);
	}

	@Test
	void _toString(){
		String result = Long.toString(Long.parseLong("8", 10), 8);
		log.debug("Long.toString(Long.parseLong(8, 10), 8) : {}",result);
		Assertions.assertEquals("10", result);
	}

	@Test
	void maxValue() {
		Long maxValue = Long.MAX_VALUE;
		System.out.println(maxValue);
		System.out.println(maxValue.toString().length());
		String max36Value = Long.toString(maxValue, 36);
		System.out.println(max36Value);
		System.out.println(max36Value.length());
	}

}