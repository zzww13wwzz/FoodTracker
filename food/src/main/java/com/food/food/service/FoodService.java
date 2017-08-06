package com.food.food.service;

import com.food.food.repository.Food;
import com.food.food.repository.FoodRepository;
import com.food.food.service.exceptions.InputValueValidationException;
import com.food.food.service.exceptions.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodService() {
    }

    @Override
    public ResponseEntity<List<String>> getFoodNames() {
        try {
            List<String> foodNamesList = new ArrayList<>();

            for (Food food : foodRepository.findAll()) {
                foodNamesList.add(food.getName());
            }

            if (foodNamesList.isEmpty()) {
                throw new ListIsEmptyException("Base are null");
            }

            return new ResponseEntity<>(foodNamesList, HttpStatus.OK);
        } catch (ListIsEmptyException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> getCalories(String name, String weight) throws InputValueValidationException {
        try {
            if (foodRepository.findByName(name) == null) {
                throw new InputValueValidationException("Food with this name not found");
            }
            Float.parseFloat(weight);
            float calories = foodRepository.findByName(name).calculateCaloriesByWeight(new Float(weight).floatValue());

            return new ResponseEntity (new Float(calories).toString(), HttpStatus.OK);
        }
        catch (InputValueValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (NumberFormatException e) {
            return new ResponseEntity("Invalid input weight", HttpStatus.BAD_REQUEST);
        }


    }
}
