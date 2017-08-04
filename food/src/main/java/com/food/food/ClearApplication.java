package com.food.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.food.food"})
public class ClearApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClearApplication.class, args);

	}
}
