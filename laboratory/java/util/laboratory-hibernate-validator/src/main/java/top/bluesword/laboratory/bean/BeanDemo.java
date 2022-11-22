package top.bluesword.laboratory.bean;

import lombok.Data;
import top.bluesword.laboratory.validation.group.StringChecks;

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

	/**
	 * @see org.springframework.boot.validation.MessageInterpolatorFactory
	 */
	@Max(value = 1,message = "字段名:{filed.integer}{error.max}")
	@NotNull
	public Integer integer;

	@NotEmpty
	@Size(min= 10,max = 500)
	public String string;

	@NotBlank(groups = StringChecks.class)
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
