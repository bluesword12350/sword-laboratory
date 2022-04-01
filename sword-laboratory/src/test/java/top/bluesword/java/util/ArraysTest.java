package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArraysTest {

	@Test
	void asList() {
		String[] strings = {"1","2"};
		List<String> asList = new ArrayList<>(Arrays.asList(strings));
		asList.remove(0);
		System.out.println(asList);
	}

	@Test
	void copyOfTest() {
		String[] strings = {"1","2"};
		String[] copyOf = Arrays.copyOf(strings, 1);
		String[] copyOfRange = Arrays.copyOfRange(strings, 1, strings.length);
		System.out.println(Arrays.toString(copyOf));
		System.out.println(Arrays.toString(copyOfRange));
	}

}
