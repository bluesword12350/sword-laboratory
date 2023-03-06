package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class HashMapTest {

	@Test
	void construct(){
		System.out.println(new HashMap<>(1) {{
			put(1, 2);
		}});
	}

	@Test
	void nullKey(){
		System.out.println(new HashMap<>(1) {{
			put(null, 1);
			put(null, 2);
		}});
	}

	@Test
	void computeIfAbsent(){
		Map<String,String> map = new HashMap<>();
		String key = "key";
		System.out.println(map.computeIfAbsent(key, k -> "test-1"));
		System.out.println(map.computeIfAbsent(key, k -> "test-2"));
		System.out.println(map);
	}

	@Test
	void computeIfPresent(){
		Map<String,String> map = new HashMap<>();
		String key = "key";
		System.out.println(map.computeIfPresent(key, (k,v) -> "test-1"));
		map.put(key,"value");
		System.out.println(map.computeIfPresent(key, (k,v) -> "test-2"));
		System.out.println(map);
	}
}
