package top.bluesword.java.util;

import org.junit.jupiter.api.Test;
import top.bluesword.java.grammar.NewTest;

import java.util.HashMap;
import java.util.Map;

class HashMapTest {

	@Test
	void newTest(){
		System.out.println(new HashMap<>() {{
			put(1, 2);
		}});
	}
}
