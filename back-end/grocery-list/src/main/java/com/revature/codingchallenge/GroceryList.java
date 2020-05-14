package com.revature.codingchallenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroceryList {

  @Id
  /* Autogenerate for testing */
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long listId;
  private String listName;

  protected GroceryList() {}

  public GroceryList(String listName) {
    this.listName = listName;
  }

  @Override
  public String toString() {
    return String.format(
        "GroceryList[listId=%d, listName='%s']",
        listId, listName);
  }

  public Long getId() {
    return listId;
  }

  public String getListName() {
    return listName;
  }

}