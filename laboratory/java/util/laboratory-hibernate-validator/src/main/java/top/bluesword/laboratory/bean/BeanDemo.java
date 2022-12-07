package top.bluesword.laboratory.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import top.bluesword.laboratory.validation.group.DiyObjectChecks;
import top.bluesword.laboratory.validation.group.StringChecks;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@DiyObjectConstraint(groups = DiyObjectChecks.class)
public class BeanDemo implements BeanDemoAbility {

	public Integer integer;

	@NotEmpty
	@Size(min= 10,max = 500)
	private String string;

	@NotBlank(groups = StringChecks.class)
	private String string2;

	@Range(min = 1,max = 999)
	private String numText;

	@DecimalMin(value = "0",inclusive = false)
	private String decimalMin;

	@Digits(integer = 2,fraction = 2)
	@NotNull
	private BigDecimal decimal;

	@NotNull
	@Size(min= 1)
	private List<String> list;

	@Valid
	@NotNull
	private InsideBeanDemo i1;

	@NotNull
	private InsideBeanDemo i2;

}
