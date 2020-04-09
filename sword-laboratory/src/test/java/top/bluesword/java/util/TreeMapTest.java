package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

class TreeMapTest {
	
	private static TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(o -> o));

	@Test
	void put() {
		treeMap.put(9, 1);
		treeMap.put(2, 1);
		treeMap.put(5, 1);
		Set<Integer> keySet = treeMap.keySet();
		for (Integer integer : keySet) {
			System.out.println(integer);
		}
	}
}
