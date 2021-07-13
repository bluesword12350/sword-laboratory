package top.bluesword.laboratory.bean;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 李林峰
 */
@Slf4j
public class DiyValidator implements ConstraintValidator<DiyConstraint,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder
                = constraintValidatorContext.buildConstraintViolationWithTemplate("发现异常：给出异常信息");
        constraintViolationBuilder.addConstraintViolation();
        return false;
    }

}
