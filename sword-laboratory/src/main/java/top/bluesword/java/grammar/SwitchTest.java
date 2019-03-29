package top.bluesword.java.grammar;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author 李林峰
 */
class SwitchTest {

	@Test
	void main() {
		Random random = new Random();
		String key = random.nextBoolean() ? "0001":"0000";
		switch (key) {
			case "0001":
			case "0000":
				System.out.println(key);
				break;
			default:break;
		}
		System.out.println(0);
	}
}