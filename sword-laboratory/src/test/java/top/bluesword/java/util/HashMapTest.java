package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class HashMapTest {

	@Test
	void construct(){
		System.out.println(new HashMap<>(1) {{
			put(1, 2);
		}});
	}
}
