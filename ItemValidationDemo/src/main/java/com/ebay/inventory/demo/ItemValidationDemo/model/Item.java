package com.ebay.inventory.demo.ItemValidationDemo.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ebay.inventory.demo.ItemValidationDemo.validation.ItemSpecificNormalized;

public class Item {
	//Spring predefined annotations for performing bean validations
	@Size(min=0, max=100,message = "siteId should be between 0 and 100")
	private int siteID;
	private int categoryID;
	@NotBlank(message = "Title is mandatory")
	@Max(value=85, message = "Title must be under 85 characters")
	private String title;
	private String condition;
	private double price;
	private int quantity;
	@ItemSpecificNormalized
	@NotEmpty(message = "itemspecifics list cannot be empty.")
	@Size(min=2, max=10,message = "number of itemspecifics should be between 2 - 10")
	private List<ItemSpecifics> itemspecifics;
	private String imageURL;
	private String description;

	public int getSiteID() {
		return siteID;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<ItemSpecifics> getItemspecifics() {
		return itemspecifics;
	}

	public void setItemspecifics(List<ItemSpecifics> itemspecifics) {
		this.itemspecifics = itemspecifics;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	


	@Override
	public String toString() {
		return "Item [siteID=" + siteID + ", categoryID=" + categoryID + ", title=" + title + ", condition=" + condition
				+ ", price=" + price + ", quantity=" + quantity + ", itemspecifics=" + itemspecifics + ", imageURL="
				+ imageURL + ", description=" + description + "]";
	}

	
	
}
