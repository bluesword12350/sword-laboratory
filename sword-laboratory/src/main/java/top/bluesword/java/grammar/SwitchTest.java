package top.bluesword.java.grammar;

import java.util.Random;

/**
 * @author 李林峰
 */
public class SwitchTest {
	public static void main(String[] args) {
		Random random = new Random();
		String key = random.nextBoolean() ? "0001":"0000";
		switch (key) {
			case "0001":
				System.out.println(key);
				break;
			case "0000":
				System.out.println(key);
				break;
			default:break;
		}
		System.out.println(0);
	}
}