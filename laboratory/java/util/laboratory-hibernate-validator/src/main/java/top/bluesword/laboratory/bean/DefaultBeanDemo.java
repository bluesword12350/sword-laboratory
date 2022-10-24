package top.bluesword.laboratory.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author 李林峰
 */
@Data
public class DefaultBeanDemo implements BeanDemoAbility {

    @Size(min= 10,max = 500)
    @NotBlank
    private String string;

}
