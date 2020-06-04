package top.bluesword.laboratory.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

/**
 * @author 李林峰
 */
public class InsideBeanDemo {

	@Max(value = 100,message = "太大了")
	public Integer integer;

	@NotEmpty
	public String string;

}