package top.bluesword.web.laboratory.bean;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 李林峰
 */
public class BeanDemo {

	@Max(value = 100,message = "太大了")
	public Integer integer;
	@NotEmpty
	public String string;

	@Valid
	@NotNull
	public InsideBeanDemo i1;

	@Valid
	public InsideBeanDemo i2;
}
