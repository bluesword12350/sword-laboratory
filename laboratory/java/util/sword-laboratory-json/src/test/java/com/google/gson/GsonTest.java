package com.google.gson;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

	@Test
	void serializedName(){
		Gson gson = new Gson();
		GsonBeanDemo gsonBeanDemo = new GsonBeanDemo();
		gsonBeanDemo.setString("123");
		String json = gson.toJson(gsonBeanDemo);
		System.out.println(json);
		GsonBeanDemo gsonBeanDemoFromJson = gson.fromJson(json, GsonBeanDemo.class);
		System.out.println(gsonBeanDemoFromJson);
	}

	@Test
	void parse(){
		Gson gson = new Gson();
		GsonBeanDemo gsonBeanDemo = new GsonBeanDemo();
		gsonBeanDemo.setString("123");
		String jsonStr = gson.toJson(gsonBeanDemo);
		JsonParser jsonParser = new JsonParser();
		JsonElement parse = jsonParser.parse(jsonStr);
		JsonObject asJsonObject = parse.getAsJsonObject();
		System.out.println(asJsonObject);
	}

	public static class BeanDemo {
		String string;
		BigDecimal bigDecimal;
	}
}
