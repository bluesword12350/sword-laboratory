package top.bluesword.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
	public static void main(String[] args) {
		String[] strings = {"1","2"};
		List<String> asList = new ArrayList<>(Arrays.asList(strings));
		asList.remove(0);
		System.out.println(asList);
	}
	
	static void copyOfTest() {
		String[] strings = {"1","2"};
		String[] copyOf = Arrays.copyOf(strings, 1);
		String[] copyOfRange = Arrays.copyOfRange(strings, 1, strings.length);
		System.out.println(Arrays.toString(copyOf));
		System.out.println(Arrays.toString(copyOfRange));
	}
}