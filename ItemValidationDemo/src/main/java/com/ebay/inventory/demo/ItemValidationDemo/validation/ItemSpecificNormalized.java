package com.ebay.inventory.demo.ItemValidationDemo.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = ItemSpecificsValidator.class)
	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ItemSpecificNormalized {
	    String message() default "Item Specifc not normalized";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	}
