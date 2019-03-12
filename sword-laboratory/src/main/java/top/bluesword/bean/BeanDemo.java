package top.bluesword.bean;

import java.math.BigDecimal;

/**
 * @author 李林峰
 */
public class BeanDemo {
	private String string;
	private BigDecimal bigDecimal;
	private InsideBeanDemo insideBeanDemo;

	public BeanDemo() {
	}

	public BeanDemo(String string) {
		this.string = string;
	}

	public BeanDemo(String string, BigDecimal bigDecimal) {
		this.string = string;
		this.bigDecimal = bigDecimal;
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}
	public InsideBeanDemo getInsideBeanDemo() {
		return insideBeanDemo;
	}
	public void setInsideBeanDemo(InsideBeanDemo insideBeanDemo) {
		this.insideBeanDemo = insideBeanDemo;
	}
}