package com.ebay.inventory.demo.ItemValidationDemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebay.inventory.demo.ItemValidationDemo.model.Item;
import com.ebay.inventory.demo.ItemValidationDemo.validation.ItemValidator;

@RestController
public class ItemValidatorController {
	
	
	@Autowired
	private ItemValidator itemValidator;
	  //@PostMapping("/items")
	  //@Valid, automatically bootstraps Spring Validator and  and validates the argument.
	  /* ResponseEntity<String> addItem(@Valid @RequestBody Item item) {
	        return ResponseEntity.ok("Item is valid");
	    }	*/
	  
	  @PostMapping("/items")
	  ResponseEntity<String> addItem(@Validated @RequestBody Item item,BindingResult bindingResult){
		  return ResponseEntity.ok("Item is valid"); 
	  }
	  
	  @InitBinder("item")
	  protected void initItemBinder(WebDataBinder binder) {
	    binder.addValidators(itemValidator);
	  }


}
