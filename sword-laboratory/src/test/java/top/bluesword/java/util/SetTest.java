package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class SetTest {

	@Test
	void containsStringTest() {
		Set<String> set = new HashSet<>();
		set.add("12");
		System.out.println(set.contains("1"+"2"));
	}

	@Test
	void sortTest() {
		List<String> strings = List.of("2", "1", "3");
		System.out.println(new HashSet<>(strings));
		System.out.println(new LinkedHashSet<>(strings));
	}
}