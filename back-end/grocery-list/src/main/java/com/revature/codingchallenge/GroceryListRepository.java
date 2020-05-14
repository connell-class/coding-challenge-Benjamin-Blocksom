package com.revature.codingchallenge;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GroceryListRepository extends CrudRepository<GroceryList, Long> {

  List<GroceryList> findByListName(String listName);

  GroceryList findById(long listId);
}
