package org.hibernate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.bean.BeanDemo;
import org.hibernate.bean.BeanDemo2;
import org.hibernate.checks.AllChecks;
import org.hibernate.checks.StringChecks;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 

	@Test
	void defaultTest(){
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> vm = validator.validate(beanDemo);
		System.out.println(vm.size());
		for (ConstraintViolation<BeanDemo> constraintViolation : vm) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	@Test
	void groubTest() {
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> vm1 = validator.validate(beanDemo,StringChecks.class);
		System.out.println(vm1.size());
		for (ConstraintViolation<BeanDemo> constraintViolation : vm1) {
			System.out.println(constraintViolation.getMessage());
		}
		
		BeanDemo2 beanDemo2 = new BeanDemo2();
		Set<ConstraintViolation<BeanDemo2>> vm2 = validator.validate(beanDemo2,AllChecks.class);
		System.out.println(vm1.size());
		for (ConstraintViolation<BeanDemo2> constraintViolation : vm2) {
			System.out.println(constraintViolation.getMessage());
		}
	}

}
