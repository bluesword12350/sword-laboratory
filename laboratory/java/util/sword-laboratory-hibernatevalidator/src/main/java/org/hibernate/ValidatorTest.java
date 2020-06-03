package org.hibernate;

import org.hibernate.checks.AllChecks;
import org.hibernate.checks.StringChecks;
import org.junit.jupiter.api.Test;
import top.bluesword.web.laboratory.bean.BeanDemo;
import top.bluesword.web.laboratory.bean.BeanDemo2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

class ValidatorTest {
	
	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	void defaultTest(){
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> vm = VALIDATOR.validate(beanDemo);
		System.out.println(vm.size());
		for (ConstraintViolation<BeanDemo> constraintViolation : vm) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	@Test
	void groupTest() {
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> vm1 = VALIDATOR.validate(beanDemo, StringChecks.class);
		System.out.println(vm1.size());
		for (ConstraintViolation<BeanDemo> constraintViolation : vm1) {
			System.out.println(constraintViolation.getMessage());
		}
		
		BeanDemo2 beanDemo2 = new BeanDemo2();
		Set<ConstraintViolation<BeanDemo2>> vm2 = VALIDATOR.validate(beanDemo2, AllChecks.class);
		System.out.println(vm1.size());
		for (ConstraintViolation<BeanDemo2> constraintViolation : vm2) {
			System.out.println(constraintViolation.getMessage());
		}
	}

}
