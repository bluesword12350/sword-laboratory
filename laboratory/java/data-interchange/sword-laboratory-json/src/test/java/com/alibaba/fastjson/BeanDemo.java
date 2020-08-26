package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author 李林峰
 */
@Data
public class BeanDemo {

	@JSONField(name = "time",format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public ZonedDateTime date;

}