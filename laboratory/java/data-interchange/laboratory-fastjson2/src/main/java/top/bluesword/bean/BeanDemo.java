package top.bluesword.bean;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author 李林峰
 */
public class BeanDemo {

	public String string;

	public BigDecimal bigDecimal;

	public Date date;

	public ZonedDateTime zonedDateTime;

	public InsideBeanDemo insideBeanDemo;

	public BeanDemo() {
	}

	public BeanDemo(String string) {
		this.string = string;
	}

	public BeanDemo(String string, BigDecimal bigDecimal) {
		this.string = string;
		this.bigDecimal = bigDecimal;
	}
}