package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

public class MathTest {

	@Test
	void main() {
		System.out.println(5/2d);
		System.out.println(Math.floor(5/2d));
		System.out.println(Math.ceil(5/2d));
		System.out.println(2<Math.ceil(5/2d));
	}

	@Test
	void random(){
		double random = Math.random();
		System.out.println(random);
		System.out.println(random>0.3);
	}

	@Test
	void log10() {
		System.out.println(Math.log10(266.66666666666666666666666666667));
	}

	@Test
	void pow() {
		System.out.println(Math.pow(10,5));
	}

}