package top.bluesword.java.util;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	
	static TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	});
	
	public static void main(String[] args) {
		treeMap.put(9, 1);
		treeMap.put(2, 1);
		treeMap.put(5, 1);
		treeMap.put(5, 1);
		Set<Integer> keySet = treeMap.keySet();
		for (Integer integer : keySet) {
			System.out.println(integer);
		}
	}
}
