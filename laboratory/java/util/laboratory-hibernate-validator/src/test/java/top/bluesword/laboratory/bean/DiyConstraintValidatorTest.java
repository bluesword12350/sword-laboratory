package top.bluesword.laboratory.bean;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

class DiyConstraintValidatorTest {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void isValid() {
        DiyValidatorBeanDemo diyValidatorBeanDemo = new DiyValidatorBeanDemo();
        diyValidatorBeanDemo.setString(" ");
        Set<ConstraintViolation<DiyValidatorBeanDemo>> validate = VALIDATOR.validate(diyValidatorBeanDemo);
        System.out.println(validate);
    }
}