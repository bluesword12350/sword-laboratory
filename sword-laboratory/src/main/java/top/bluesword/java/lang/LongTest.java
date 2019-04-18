package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class LongTest {

	@Test
	void parseLong() {
		long parseInt = Long.parseLong("AB",16);
		String string = Long.toString(parseInt, 36);
		System.out.println(string);
	}

	@Test
	void valueOf(){
		System.out.println(Long.valueOf("4"));
	}
}