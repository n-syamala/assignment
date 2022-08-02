package com.ebay.inventory.demo.ItemValidationDemo.controller;

import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ebay.inventory.demo.ItemValidationDemo.model.Item;

@RunWith(SpringRunner.class)
//below annotation is for running the context first, before performing validation like an end to end test
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemValidatorTest {
	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeTestClass
	public static void createValidator() {
	    validatorFactory = Validation.buildDefaultValidatorFactory();
	    validator = validatorFactory.getValidator();
	}
	
	@Test
	public void shouldReturnViolation() {
	    Item item = new Item();
	    item.setSiteID(112);
	    Set<ConstraintViolation<Item>> violations = validator.validate(item);
	    assertFalse(violations.isEmpty());
	}

	@AfterTestClass
	public static void close() {
	    validatorFactory.close();
	}

}
