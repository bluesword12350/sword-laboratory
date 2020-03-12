package top.bluesword.web.laboratory.bean;

import org.hibernate.checks.AllChecks;
import org.hibernate.checks.BigDecimalChecks;
import org.hibernate.checks.StringChecks;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class BeanDemo2 {
	
	@NotEmpty(message="字符串不能为空",groups = {StringChecks.class, AllChecks.class})
	private String string;
	
	@NotNull(message="数字不能为空",groups = {BigDecimalChecks.class, AllChecks.class})
	private BigDecimal bigDecimal;
	
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
}