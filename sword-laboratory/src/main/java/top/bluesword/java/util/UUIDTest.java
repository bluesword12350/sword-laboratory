package top.bluesword.java.util;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		String string = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(string);
		System.out.println(string.length());
		String substring = string.replaceAll("-", "").toUpperCase().substring(17);
		System.out.println(substring);
		System.out.println(substring.length());
	}
}