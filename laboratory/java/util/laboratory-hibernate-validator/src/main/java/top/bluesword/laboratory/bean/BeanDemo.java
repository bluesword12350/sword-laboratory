package top.bluesword.laboratory.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
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
public class BeanDemo implements BeanDemoAbility {

	public Integer integer;

	@NotEmpty
	@Size(min= 10,max = 500)
	public String string;

	@NotBlank(groups = StringChecks.class)
	public String string2;

	@Range(min = 1,max = 999)
	public String numText;

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
