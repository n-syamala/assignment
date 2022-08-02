package com.ebay.inventory.demo.ItemValidationDemo.validation;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.ebay.inventory.demo.ItemValidationDemo.model.ItemSpecifics;

@Component
public class ItemSpecificNormalizationService {
	
	/**
	 * takes  itemSpecifics and returns normalized 
	 * @return
	 */
	@Async
	public CompletableFuture<ItemSpecifics> normalize(ItemSpecifics itSpec){
			String itSpecName=itSpec.getItemSpecificName().toLowerCase();
			String temp = itSpecName.substring(0, 1).toUpperCase();
		    String nameCapitalized = temp + itSpecName.substring(1);
		    itSpec.setItemSpecificName(nameCapitalized);
		    try {
		    	//add  a delay here 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return CompletableFuture.completedFuture(itSpec);
}

	
}