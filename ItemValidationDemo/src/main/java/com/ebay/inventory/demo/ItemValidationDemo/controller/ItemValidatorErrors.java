package com.ebay.inventory.demo.ItemValidationDemo.controller;


public class ItemValidatorErrors {
	
	private int errorId;
	private String errorMessage;
	private String errorDetails;
	

	public ItemValidatorErrors(String errorMessage, String errorDetails) {
		super();
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
