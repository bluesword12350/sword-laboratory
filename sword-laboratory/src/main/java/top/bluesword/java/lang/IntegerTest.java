package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class IntegerTest {

	@Test
	void eqTest(){
		Integer i1 = 1;
		Integer i2 = 1;
		System.out.println(i1==i2);
		Integer i3 = 129;
		Integer i4 = 129;
		System.out.println(i3==i4);
	}

	@Test
	void binaryString(){
		System.out.println(Integer.toBinaryString(8));
	}

	@Test
	void sqrt(){
		System.out.println(46341L * 46341L - Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE - 46340 * 46340);
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
}