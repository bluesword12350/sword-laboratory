package org.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.bean.BeanDemo;
import top.bluesword.laboratory.bean.BeanDemoAbility;
import top.bluesword.laboratory.bean.InsideBeanDemo;
import top.bluesword.laboratory.validation.group.StringChecks;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Slf4j
class ValidatorTest {
	
	private static final Validator VALIDATOR;

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		try(validatorFactory) {
			VALIDATOR = validatorFactory.getValidator();
		}
	}

	@Test
	void defaultTest() {
		BeanDemo beanDemo = new BeanDemo();
		beanDemo.setInteger(100);
		beanDemo.setString(" ");
		beanDemo.setString2(" ");
		beanDemo.setDecimal(BigDecimal.valueOf(134165448.1324564768));
		beanDemo.setI1(new InsideBeanDemo());
		beanDemo.setI2(new InsideBeanDemo());
		beanDemo.setList(List.of());

		Set<ConstraintViolation<BeanDemo>> vm = VALIDATOR.validate(beanDemo);
		printViolation(vm);
	}

	private <T> void printViolation(Set<ConstraintViolation<T>> vm) {
		for (ConstraintViolation<T> constraintViolation : vm) {
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
		Set<ConstraintViolation<BeanDemo>> validateResult = VALIDATOR.validate(beanDemo, StringChecks.class);
		log.info("{}",validateResult.size());
		printViolation(validateResult);
	}

	@Test
	void extendTest(){
		BeanDemoAbility defaultBeanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemoAbility>> validateResult = VALIDATOR.validate(defaultBeanDemo);
		printViolation(validateResult);
	}

}
