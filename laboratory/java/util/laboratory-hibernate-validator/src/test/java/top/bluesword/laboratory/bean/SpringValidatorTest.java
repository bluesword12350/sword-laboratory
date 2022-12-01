package top.bluesword.laboratory.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.PrintViolationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootTest
class SpringValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void test(){
        BeanDemo beanDemo = new BeanDemo();
        beanDemo.setInteger(100);
        Set<ConstraintViolation<BeanDemo>> validateResult = this.validator.validate(beanDemo);
        PrintViolationUtils.print(validateResult);
    }

}
