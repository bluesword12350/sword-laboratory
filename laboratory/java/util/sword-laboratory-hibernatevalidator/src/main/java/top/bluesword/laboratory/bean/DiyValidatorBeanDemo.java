package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 李林峰
 */
@Data
public class DiyValidatorBeanDemo {

    @NotEmpty
    @Diy
    public String string;

}
