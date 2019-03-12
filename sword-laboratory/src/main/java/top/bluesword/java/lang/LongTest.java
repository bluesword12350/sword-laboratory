package top.bluesword.java.lang;

public class LongTest {
	public static void main(String[] args) {
		long parseInt = Long.parseLong("AB",16);
		String string = Long.toString(parseInt, 36);
		System.out.println(string);
	}
}
