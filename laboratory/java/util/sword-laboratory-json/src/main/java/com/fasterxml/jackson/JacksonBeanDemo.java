package com.fasterxml.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李林峰
 */
public class JacksonBeanDemo {

	@JsonProperty("name")
	public String string;

	@JsonSerialize(using = ToStringSerializer.class)
	public BigDecimal bigDecimal;

	public Date date;

	public JacksonBeanDemo() {
	}

	public JacksonBeanDemo(String string) {
		this.string = string;
	}

	public JacksonBeanDemo(String string, BigDecimal bigDecimal) {
		this.string = string;
		this.bigDecimal = bigDecimal;
	}
}