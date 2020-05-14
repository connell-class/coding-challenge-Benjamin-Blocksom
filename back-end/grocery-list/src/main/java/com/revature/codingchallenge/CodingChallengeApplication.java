package com.revature.codingchallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CodingChallengeApplication {

  private static final Logger log = LoggerFactory.getLogger(CodingChallengeApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CodingChallengeApplication.class);
  }

  @Bean
  public CommandLineRunner demo(GroceryListRepository repository) {
    return (args) -> {
      // save a few new GroceryLists
      repository.save(new GroceryList( "My List"));
      repository.save(new GroceryList( "Your List"));
      repository.save(new GroceryList("Store List"));
      
      // fetch all GroceryLists
      log.info("Grocery Lists found with findAll():");
      log.info("-------------------------------");
      for (GroceryList myGroceryList : repository.findAll()) {
        log.info(myGroceryList.toString());
      }
      log.info("");

      // fetch an individual GroceryList by ID
      GroceryList myGroceryList = repository.findById(1L);
      log.info("Grocery List found with findById(1L):");
      log.info("--------------------------------");
      log.info(myGroceryList.toString());
      log.info("");

      // fetch Grocery List by list name
      log.info("Grocery List found with findByListName('Store List'):");
      log.info("--------------------------------------------");
      repository.findByListName("Store List").forEach(storeList -> {
        log.info(storeList.toString());
      });
     log.info("");
    };
  }

}