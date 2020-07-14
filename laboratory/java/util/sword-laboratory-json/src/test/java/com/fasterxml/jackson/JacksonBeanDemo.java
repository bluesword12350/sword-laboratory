package com.fasterxml.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import top.bluesword.serialize.CustomNumberSerialize;
import top.bluesword.serialize.NoDecimalNumberSerialize;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李林峰
 */
@Data
public class JacksonBeanDemo {

	@JsonProperty("name")
	public String string;

	@JsonSerialize(using = ToStringSerializer.class)
	public BigDecimal bigDecimal;

	@JsonSerialize(using = CustomNumberSerialize.class)
	public BigDecimal number;

	@JsonSerialize(using = NoDecimalNumberSerialize.class)
	public BigDecimal integer;

	public Date date;

}