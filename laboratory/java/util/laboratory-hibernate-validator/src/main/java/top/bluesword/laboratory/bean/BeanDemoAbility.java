package top.bluesword.laboratory.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author 李林峰
 */
public interface BeanDemoAbility {

    /**
     * 整数
     * @see org.springframework.boot.validation.MessageInterpolatorFactory
     * @return 整数
     */
    @NotNull
    @Max(value = 1,message = "字段名:{filed.integer}{error.max}")
    Integer getInteger();

}
