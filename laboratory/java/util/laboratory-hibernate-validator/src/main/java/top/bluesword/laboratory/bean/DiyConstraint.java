package top.bluesword.laboratory.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 李林峰
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DiyValidator.class)
public @interface DiyConstraint {
    String message() default "范围错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
