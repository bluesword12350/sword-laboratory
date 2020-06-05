package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

/**
 * @author 李林峰
 */
@Data
public class InsideBeanDemo {

	@Max(value = 100,message = "太大了")
	public Integer integer;

	@NotEmpty
	public String string;

}