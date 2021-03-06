package top.bluesword.java.util;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapTest {

	@Test
	void keySet(){
		Map<String, String> map = new HashMap<>(1);
		map.put("1", "一");
		map.put("2", "二");
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
	}

	@Test
	void values(){
		Map<String, String> map = new HashMap<>(1);
		map.put("1", "一");
		map.put("2", "二");
		for (String value : map.values()) {
			System.out.println(value);
		}
	}
}