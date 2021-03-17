package top.bluesword.laboratory.bean;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 李林峰
 */
@Slf4j
public class DiyObjectValidator implements ConstraintValidator<DiyObjectConstraint,BeanDemo> {

    @Override
    public boolean isValid(BeanDemo demo, ConstraintValidatorContext constraintValidatorContext) {
        log.debug("DiyObjectValidator 校验开始");
        waitMillis();
        log.debug("DiyObjectValidator 校验结束");
        return false;
    }

    private void waitMillis() {
        long now = System.currentTimeMillis();
        for (long time = System.currentTimeMillis();time<now+1000;){
            time = System.currentTimeMillis();
        }
    }

}
