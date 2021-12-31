package top.bluesword.laboratory.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultBeanDemo extends AbstractBeanDemo {

    @Override
    @Size(min= 10,max = 500)
    public String getString(){
        return this.string;
    }

}
