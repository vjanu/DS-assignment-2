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
public class SMSApplication {
	
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
    public Map getSMS() {
		Map<String,String> smsMap = new HashMap<>();
		smsMap.put("sms", "SMS Sent Successfully To Your Number");
		return smsMap;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SMSApplication.class, args);
	}
}
