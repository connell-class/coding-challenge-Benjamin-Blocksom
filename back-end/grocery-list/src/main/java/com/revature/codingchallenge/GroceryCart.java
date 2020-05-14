package com.revature.codingchallenge;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GroceryCart {
	
	private Long groceryListId;
	private String itemName;
	private int quantity;

	protected GroceryCart() {}

	public GroceryCart(Long groceryListId, String itemName, int quantity) {
		this.groceryListId = groceryListId;
		this.itemName = itemName;
		this.quantity = quantity;
	  }

	  @Override
	  public String toString() {
	    return String.format(
	        "GroceryList[groceryListId=%d, listName='%s', quantity=%d]",
	        groceryListId, itemName, quantity);
	  }

	  public Long getId() {
	    return groceryListId;
	  }

	  public String getItemName() {
	    return itemName;
	  }
	  
	  public int getQuantity() {
		    return quantity;
		  }
}