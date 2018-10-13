package com.food.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class LoyaltyPointsApplication {
	
	String details;
	String data[];
	LoyaltyPointsApplication loyaltyPointsApplication =  new LoyaltyPointsApplication();
	
	
	@RequestMapping(value = "/loyalty", method = RequestMethod.GET)
    public int getSMS(double billValue, int phone) {
		
		//for each rs 100, one loyalty points is added
		int pointsCount = (int)billValue/100;
		
		//dummy service to get the current loyalty points count from the relevant customer
		int currentCount = loyaltyPointsApplication.getCustomerPointsCount(phone);
		return currentCount + pointsCount;
    }
	
	public int getCustomerPointsCount(int phone) {
		try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
        		(LoyaltyPointsApplication.class.getResourceAsStream("loyalty.txt")))) {

            // traverse through each line available in the text file
        	
            while ((details = bufferedReader.readLine()) != null) {
            	
            	data = details.split("-");
            
            	if(Integer.parseInt(data[1])== phone) {
            		return Integer.parseInt(data[2]);
            	}
            }
        } catch (IOException e) {
            System.err.println("No Loyalty Points "+e.getMessage());
        }
		return 0;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LoyaltyPointsApplication.class, args);
	}
}
