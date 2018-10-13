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
public class DialogPaymentGatewayApplication {
	
	@RequestMapping(value = "/dialogpay", method = RequestMethod.GET)
    public Map getDialogPay() {
		Map<String,String> dialogMap = new HashMap<>();
		dialogMap.put("dialog", "Bill was successfully paid with your mobile");
		return dialogMap;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DialogPaymentGatewayApplication.class, args);
	}
}
