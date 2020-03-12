package org.apache.commons.beanutils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;

class BeanUtilsTest {

	@Test
	void getPropertyTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		User bean = new User();
		bean.setPassword("12350");
		bean.setUsername("龙仔");
        bean.setFriends(List.of(new User()));
        String password = BeanUtils.getProperty(bean, "password");
        System.out.println(password);
        String friends = BeanUtils.getProperty(bean, "friends");
        System.out.println(friends);
    }

	@Test
	void describeTest() {
		User bean = new User();
		bean.setPassword("12350");
		bean.setUsername("龙仔");
		try {
			Map<String, String> describe = BeanUtils.describe(bean);
			describe.remove("class");
			List<Map.Entry<String, String>> infoIds = new ArrayList<>(describe.entrySet());
	        infoIds.sort(Comparator.comparing(o -> (o.getKey())));
	        StringBuilder unencrypteds = new StringBuilder();
			for (Entry<String, String> entry : infoIds) {
				if (!StringUtils.isBlank(entry.getValue())) unencrypteds.append("&").append(entry.toString());
			}
			unencrypteds = new StringBuilder(unencrypteds.substring(1));
	        System.out.println(unencrypteds);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
