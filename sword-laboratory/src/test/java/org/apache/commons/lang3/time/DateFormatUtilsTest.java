package org.apache.commons.lang3.time;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TimeZone;

class DateFormatUtilsTest {

	@Test
	void formatTest(){
        Date date = new Date();
		System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss.SSS ZZ"));
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss.SSS ZZ",TimeZone.getTimeZone("UCT")));
		System.out.println(DateFormatUtils.format(date, "('UTC' X) yyyy/MM/dd HH:mm"));
		System.out.println(DateFormatUtils.format(date, "('UTC' XX) yyyy/MM/dd HH:mm"));
		System.out.println(DateFormatUtils.format(date, "('UTC' XXX) yyyy/MM/dd HH:mm"));

		System.out.println(DateFormatUtils.format(date, "'UTC'(z) yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateFormatUtils.format(date, "'UTC'(Z) yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateFormatUtils.format(date, "'UTC'(ZZ) yyyy-MM-dd HH:mm:ss"));
	}

}