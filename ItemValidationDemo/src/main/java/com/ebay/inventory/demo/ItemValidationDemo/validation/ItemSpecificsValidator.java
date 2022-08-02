package com.ebay.inventory.demo.ItemValidationDemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebay.inventory.demo.ItemValidationDemo.model.ItemSpecifics;

public class ItemSpecificsValidator implements ConstraintValidator<ItemSpecificNormalized, ItemSpecifics>{

	 @Autowired
	 private ItemSpecificNormalizationService itemSpecificNormalizationService;
	
	@Override
	public boolean isValid(ItemSpecifics value, ConstraintValidatorContext context) {
		itemSpecificNormalizationService.normalize(value);
	    //after normalization, additional validation on itemSpecific goes here
		return true;
	}
	

   


}
