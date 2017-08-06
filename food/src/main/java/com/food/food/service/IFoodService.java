package com.food.food.service;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IFoodService {
    ResponseEntity<List<String>> getFoodNames();
    ResponseEntity<String> getCalories(String name, String weight);
}
