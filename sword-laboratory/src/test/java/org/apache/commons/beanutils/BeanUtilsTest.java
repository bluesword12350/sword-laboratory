package org.apache.commons.beanutils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.User;

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
	        infoIds.sort(Entry.comparingByKey());
	        StringBuilder builder = new StringBuilder();
			for (Entry<String, String> entry : infoIds) {
				if (!StringUtils.isBlank(entry.getValue())) builder.append("&").append(entry.toString());
			}
			builder = new StringBuilder(builder.substring(1));
	        System.out.println(builder);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
