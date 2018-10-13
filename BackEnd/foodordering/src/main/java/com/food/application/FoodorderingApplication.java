package com.food.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.FoodDAO;
import com.food.dao.UserDAO;
import com.google.gson.Gson;


@SpringBootApplication
@RestController
public class FoodorderingApplication {

	
    //rest request to populate the food items in the restaurant to the user view
    @RequestMapping(value = "/foodlist", method = RequestMethod.GET)
    public String getFoodList() {
     FoodDAO food = new FoodDAO();
     String json = new Gson().toJson(food.populateFoodDetails() );
     return json;
    }
    
    //rest request to get all the customers who have registered
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String getUserList() {
     UserDAO user = new UserDAO();
     String json = new Gson().toJson(user.populateUserDetails() );
     return json;
    }
    
	
	
	public static void main(String[] args) {
		SpringApplication.run(FoodorderingApplication.class, args);
	}
}
