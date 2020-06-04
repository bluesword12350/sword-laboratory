package com.google.gson;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

class GsonTest {

	@Test
	void main() {
		Gson gson = new GsonBuilder().serializeNulls().create();
		Map<String, Object> map = new HashMap<>();
		map.put("string", "");
		map.put("bigDecimal", null);
        String jsonString = gson.toJson(map);
        System.out.println(jsonString);
        Type type= new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> fromJsonMap = gson.fromJson(jsonString, type);
        BeanDemo fromJsonBean = gson.fromJson(jsonString, BeanDemo.class);
        System.out.println("fromJsonMap中string:"+fromJsonMap.get("string"));
        System.out.println("fromJsonMap中bigDecimal是null:"+(fromJsonMap.get("bigDecimal")==null));
        
        System.out.println("fromJsonBean中string:"+fromJsonBean.string);
        System.out.println("fromJsonBean中bigDecimal是null:"+(fromJsonBean.bigDecimal==null));
	}
	
	public static class BeanDemo {
		String string;
		BigDecimal bigDecimal;
	}
}
