package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author 李林峰
 */
@Data
public class BeanDemo {

	@JSONField(name = "time")
	public Date date;

}