package org.apache.commons.lang3.time;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TimeZone;

class DateFormatUtilsTest {

	@Test
	void formatTest(){
        Date date = new Date();
		System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSS ZZ"));
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSS ZZ",TimeZone.getTimeZone("UCT")));
		System.out.println(DateFormatUtils.format(date, "('UTC' X) yyyy/MM/dd HH:mm"));
	}
}