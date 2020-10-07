package org.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.bean.BeanDemo;
import top.bluesword.laboratory.bean.InsideBeanDemo;
import top.bluesword.laboratory.validation.group.StringChecks;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

@Slf4j
class ValidatorTest {
	
	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	void defaultTest() {
		BeanDemo beanDemo = new BeanDemo();
		beanDemo.setInteger(100);
		beanDemo.setString("13246");
		beanDemo.setDecimal(BigDecimal.valueOf(134165448.1324564768));
		beanDemo.setI1(new InsideBeanDemo());
		beanDemo.setI2(new InsideBeanDemo());

		Set<ConstraintViolation<BeanDemo>> vm = VALIDATOR.validate(beanDemo);
		printViolation(vm);
	}

	private void printViolation(Set<ConstraintViolation<BeanDemo>> vm) {
		for (ConstraintViolation<BeanDemo> constraintViolation : vm) {
			log.error("{}:{}", constraintViolation.getPropertyPath(), constraintViolation.getMessage());
		}
	}

	@Test
	void sizeTest(){
		BeanDemo beanDemo = new BeanDemo();
		beanDemo.setString("0123456789");
		Set<ConstraintViolation<BeanDemo>> validate = VALIDATOR.validate(beanDemo);
		printViolation(validate);
	}

	@Test
	void groupTest() {
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> vm1 = VALIDATOR.validate(beanDemo, StringChecks.class);
		System.out.println(vm1.size());
		printViolation(vm1);
	}

}
