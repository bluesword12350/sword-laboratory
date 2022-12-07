package org.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.PrintViolationUtils;
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
		beanDemo.setNumText("1");
		beanDemo.setDecimal(BigDecimal.valueOf(134165448.1324564768));
		beanDemo.setI1(new InsideBeanDemo());
		beanDemo.setI2(new InsideBeanDemo());
		beanDemo.setList(List.of());

		Set<ConstraintViolation<BeanDemo>> vm = VALIDATOR.validate(beanDemo);
		PrintViolationUtils.print(vm);
	}

	@Test
	void sizeTest(){
		BeanDemo beanDemo = new BeanDemo();
		beanDemo.setString("0123456789");
		Set<ConstraintViolation<BeanDemo>> validate = VALIDATOR.validate(beanDemo);
		PrintViolationUtils.print(validate);
	}

	@Test
	void groupTest() {
		BeanDemo beanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemo>> validateResult = VALIDATOR.validate(beanDemo, StringChecks.class);
		log.info("{}",validateResult.size());
		PrintViolationUtils.print(validateResult);
	}

	@Test
	void extendTest(){
		BeanDemoAbility defaultBeanDemo = new BeanDemo();
		Set<ConstraintViolation<BeanDemoAbility>> validateResult = VALIDATOR.validate(defaultBeanDemo);
		PrintViolationUtils.print(validateResult);
	}

	@Test
	void decimalMinTest(){
		BeanDemo beanDemo = new BeanDemo();
		beanDemo.setDecimalMin("0");
		Set<ConstraintViolation<BeanDemo>> validate = VALIDATOR.validate(beanDemo);
		PrintViolationUtils.print(validate);
	}

}
