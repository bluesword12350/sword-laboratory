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
			case "0001", "0000" -> System.out.println(key);
			default -> System.out.println("default");
		}
	}
}