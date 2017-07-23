package com.food.clear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.food.clear.Manager"})

public class ClearApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClearApplication.class, args);

	}
}
