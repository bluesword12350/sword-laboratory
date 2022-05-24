package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeMap;

class TreeMapTest {

	@Test
	void put() {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>(Integer::compareTo);
		treeMap.put(9, 1);
		treeMap.put(2, 1);
		treeMap.put(5, 1);
		Set<Integer> keySet = treeMap.keySet();
		for (Integer integer : keySet) {
			System.out.println(integer);
		}
	}
}
