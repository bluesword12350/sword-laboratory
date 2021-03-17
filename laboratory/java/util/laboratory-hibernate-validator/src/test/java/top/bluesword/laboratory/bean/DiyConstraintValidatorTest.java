package top.bluesword.laboratory.bean;

import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

class DiyConstraintValidatorTest {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void isValid() {
        VALIDATOR.validate(new DiyValidatorBeanDemo());
    }
}