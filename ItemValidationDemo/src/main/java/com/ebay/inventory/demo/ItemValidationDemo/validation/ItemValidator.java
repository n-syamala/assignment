package com.ebay.inventory.demo.ItemValidationDemo.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ebay.inventory.demo.ItemValidationDemo.model.Item;

import org.springframework.validation.ValidationUtils;

/**
 * custom class for item validations
 *
 */
@Component
public class ItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item) target; 
		//check if siteId is in between 0 and 100, do all other validations
		if( item.getSiteID() <100 && item.getSiteID()>0) {
			//ValidationUtils.rejectValue(errors, field, errorCode);
		}

		
	}

	

}
