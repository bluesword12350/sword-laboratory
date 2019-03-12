package org.apache.commons.lang3.time;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TimeZone;

class DateFormatUtilsTest {

	@Test
	void formatTest(){
        Date date = new Date(Long.MAX_VALUE);
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSSZZ",
				TimeZone.getTimeZone("UCT")));
	}
}