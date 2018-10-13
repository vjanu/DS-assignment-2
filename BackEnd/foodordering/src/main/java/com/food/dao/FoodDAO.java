package com.food.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.food.bean.FoodBean;
import com.food.services.FoodService;


public class FoodDAO implements FoodService{
	String details;
	String data[];
	String name;
	String description;
	double price;

	//populate table view of food in the Customer view 
	@Override
	public List populateFoodDetails() {
		List<FoodBean> foodList = new ArrayList<>();
		
		
		  try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
	        		(FoodDAO.class.getResourceAsStream("foodetails.txt")))) {

	           
	            // traverse through each line available in the text file
	        	
	            while ((details = bufferedReader.readLine()) != null) {
	            	FoodBean foodBean = new FoodBean();
	            	data = details.split("-");
	            	name = data[0];
	            	description = data[1];
	            	price = Double.parseDouble(data[2]);
	            	
	            	foodBean.setFoodName(name);
	            	foodBean.setFoodDescription(description);
	            	foodBean.setPrice(price);
	            	
	            	foodList.add(foodBean);
	            	
	            }
	        } catch (IOException e) {
	            System.err.println("Login cannot be done "+e.getMessage());
	        }
		
	
		return foodList;
}



}

