package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author 李林峰
 */
public class RandomTest {

	private final Random random = new Random();

	@Test
	void nextIntTest() {
		int co = 0,cz = 0;
		for (int i = 0; i < 1000; i++) {
			int num = random.nextInt(2);
			if (num==0) {
				cz++;
			} else {
				co++;
			}
		}
		System.out.println("1的数量"+co);
		System.out.println("0的数量"+cz);
	}

	@Test
	void nextInt4Test() {
		System.out.printf("%04d%n", 123456789);
	}

	@Test
	void seedTest(){
		Random random1 = new Random(23468);
		for (int i = 0;i < 10;i++) {
			System.out.println(random1.nextInt(1000));
		}
		System.out.println();
		Random random2 = new Random(23468);
		for (int i = 0;i < 10;i++) {
			System.out.println(random2.nextInt(1000));
		}
	}
}