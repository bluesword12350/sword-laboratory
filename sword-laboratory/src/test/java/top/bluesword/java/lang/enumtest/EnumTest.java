package top.bluesword.java.lang.enumtest;

public class EnumTest {
	public static void main(String[] args) {
		DemoEnum valueOf = DemoEnum.valueOf("1");
		System.out.println(valueOf);
	}
	
	public static DemoEnum enumValueTest() {
		DemoEnum one = DemoEnum.ONE;
		one.setName("tree");
		System.out.println(one.getName());
		return one;
	}
	
	public static DemoEnum enumValueTest2() {
		DemoEnum one = DemoEnum.ONE;
		System.out.println(one.getName());
		return one;
	}
}