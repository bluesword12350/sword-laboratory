package top.bluesword.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李林峰
 */
public class BeanDemo {
	public String string;

	public BigDecimal bigDecimal;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS ZZ")
	public Date date;

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