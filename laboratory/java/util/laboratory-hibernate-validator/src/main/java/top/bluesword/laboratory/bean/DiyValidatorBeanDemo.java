package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 李林峰
 */
@Data
public class DiyValidatorBeanDemo {

    @NotBlank
    @DiyConstraint
    public String string;

}
