package com.alibaba.fastjson;

import com.alibaba.fastjson.FastJsonTest.BeanDemo.InsideBeanDemo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class FastJsonTest {

	@Test
	void nullTest(){
		if (new JSONObject().getBoolean("data")) System.out.println(1);
		else System.out.println(2);
	}

	@Test
	void mapInBean() {
		Map<String, Object> virtualBeanMap = new HashMap<>(2);
		Map<String, Object> insideMap = new HashMap<>(2);
		Map<String, Object> i2map = new HashMap<>(1);

		String insideMapName = "insideMap";
		virtualBeanMap.put("name", "virtualBeanMap");
		virtualBeanMap.put(insideMapName, insideMap);
		insideMap.put("i2map", i2map);
		insideMap.put("name", insideMapName);
		i2map.put("name", "i2map");
		String jsonString = JSON.toJSONString(virtualBeanMap);
        System.out.println(jsonString);
        
        Map<String, Object> parseObject = JSON.parseObject(jsonString, new TypeReference<>() {});
        Object insideMapObject = parseObject.get(insideMapName);
        System.out.println(insideMapObject.getClass());
        String jsonString2 = JSON.toJSONString(parseObject);
        System.out.println(jsonString2);
	}

	@Test
	void multilayerJson() {
		BeanDemo beanDemo=new BeanDemo();
		beanDemo.string="beanDemo";
		InsideBeanDemo insideBeanDemo = new InsideBeanDemo();
		insideBeanDemo.string = "insideBeanDemo";
		beanDemo.insideBeanDemo = insideBeanDemo;
		
        String jsonString = JSON.toJSONString(beanDemo,SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(jsonString);
        
        BeanDemo parseObject = JSON.parseObject(jsonString, BeanDemo.class);
        
        String jsonString2 = JSON.toJSONString(parseObject);
        System.out.println(jsonString2);
	}

	@Test
	void nullInJson() {
		BeanDemo beanDemo=new BeanDemo();
        String jsonString = JSON.toJSONString(beanDemo,SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(jsonString);
        TypeReference<Map<String, Object>> mapType = new TypeReference<>() {};
        Map<String, Object> parseObject = JSON.parseObject(jsonString, mapType);
        System.out.println("string:"+parseObject.get("string"));
        System.out.println("bigDecimal是null:"+(parseObject.get("bigDecimal")==null));
	}

	static class BeanDemo {
		public String string;
		InsideBeanDemo insideBeanDemo;
		
		static class InsideBeanDemo {
			public String string;
		}
	}
}