package com.food.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class EmailApplication {
	

	@RequestMapping(value = "/email", method = RequestMethod.GET)
    public Map getMail() {
		Map<String,String> emailMap = new HashMap<>();
		emailMap.put("email", "Email Sent Successfully");
		return emailMap;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}
}
