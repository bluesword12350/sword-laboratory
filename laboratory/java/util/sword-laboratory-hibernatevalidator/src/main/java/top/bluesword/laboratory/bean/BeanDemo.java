package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author 李林峰
 */
@Data
public class BeanDemo {

	@Max(value = 1,message = "太大了")
	@NotNull
	public Integer integer;

	@NotEmpty
	public String string;

	@Digits(integer = 2,fraction = 2)
	@NotNull
	public BigDecimal decimal;

	@Valid
	@NotNull
	public InsideBeanDemo i1;

	@NotNull
	public InsideBeanDemo i2;

}
