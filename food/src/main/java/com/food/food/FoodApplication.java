package com.food.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("module-service")

//extends SpringBootServletInitializer{
public class FoodApplication {

//	@Override protected org.springframework.boot.builder.SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(FoodApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}


}
