package org.ocpsoft.prettytime;

import java.util.Date;

public class PrettyTimeTest {
	public static void main(String[] args) {
		PrettyTime p = new PrettyTime();
		System.out.println(p.format(new Date()));
	}
}