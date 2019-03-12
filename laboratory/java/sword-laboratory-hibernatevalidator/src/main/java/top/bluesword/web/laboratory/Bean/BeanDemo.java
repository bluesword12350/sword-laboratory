package top.bluesword.web.laboratory.Bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class BeanDemo {
	@Max(value = 100,message = "太大了")
	public Integer integer;
	@NotEmpty
	public String string;
}
