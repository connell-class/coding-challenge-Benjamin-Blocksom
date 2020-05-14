package com.revature.codingchallenge;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GroceryCartRepository extends CrudRepository<GroceryCart, Long> {

	  List<GroceryCart> findByListName(String listName);

	  GroceryCart findById(long groceryListId);
	}
