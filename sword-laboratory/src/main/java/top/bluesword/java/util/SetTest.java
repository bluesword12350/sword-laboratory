package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class SetTest {

	@Test
	void containsStringTest() {
		Set<String> set = new HashSet<>();
		set.add("12");
		System.out.println(set.contains("1"+"2"));
	}
}