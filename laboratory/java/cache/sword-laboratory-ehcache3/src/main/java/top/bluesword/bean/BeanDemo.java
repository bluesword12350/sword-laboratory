package top.bluesword.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李林峰
 */
public class BeanDemo implements Serializable {

	public String string;

	public BigDecimal bigDecimal;

	public Date date;

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