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
public class DrawApplication {
	
	
	@RequestMapping(value = "/draw", method = RequestMethod.GET)
    public Map getDraw() {
		Map<String,String> drawMap = new HashMap<>();
		drawMap.put("draw", "Customer is Chosen");
		return drawMap;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DrawApplication.class, args);
	}
}
