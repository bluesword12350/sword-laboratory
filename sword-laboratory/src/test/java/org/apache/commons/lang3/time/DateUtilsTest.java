package org.apache.commons.lang3.time;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

class DateUtilsTest {

	@Test
	void parse() throws ParseException {
		Date date = DateUtils.parseDate("2020-07-30T07:43:55.079+0000", "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(date));
	}

	@Test
	void addHours() {
		Date date = new Date();
		Date date2 = DateUtils.addHours(date, -1);
		Date date3 = DateUtils.addHours(date2, 1);
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(date));
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(date2));
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(date3));
	}

	@Test
	void addYears(){
		Date date = new Date();
		Date addYears = DateUtils.addYears(date, -1);
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(addYears));
	}

	@Test
	void addDays(){
		Date date = DateUtils.addDays(new Date(), 429);
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(date));
	}
}