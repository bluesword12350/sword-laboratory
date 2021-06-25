package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@DiyObjectConstraint
public class BeanDemo {

	@Max(value = 1,message = "太大了")
	@NotNull
	public Integer integer;

	@NotEmpty
	@Size(min= 10,max = 500)
	public String string;

	@NotBlank
	public String string2;

	@Digits(integer = 2,fraction = 2)
	@NotNull
	public BigDecimal decimal;

	@NotNull
	@Size(min= 1)
	public List<String> list;

	@Valid
	@NotNull
	public InsideBeanDemo i1;

	@NotNull
	public InsideBeanDemo i2;

}
