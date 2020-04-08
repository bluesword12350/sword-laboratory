package top.bluesword.java.lang;

public class MathTest {
	public static void main(String[] args) {
		System.out.println(5/2d);
		System.out.println(Math.floor(5/2d));
		System.out.println(Math.ceil(5/2d));
		System.out.println(2<Math.ceil(5/2d));
	}
	
	void randomTest(){
		double random = Math.random();
		System.out.println(random);
		System.out.println(random>0.3);
	}
	
	void log10Test() {
		System.out.println(Math.log10(266.66666666666666666666666666667));
	}
}