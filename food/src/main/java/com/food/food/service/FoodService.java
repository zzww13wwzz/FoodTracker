package com.food.food.service;

import com.food.food.repository.Food;
import com.food.food.repository.FoodRepository;
import com.food.food.service.exceptions.InputValueValidationException;
import com.food.food.service.exceptions.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> getFoodNames() throws ListIsEmptyException {

        List<String> foodNamesList = new ArrayList<>();

        for (Food food : foodRepository.findAll()) {
            foodNamesList.add(food.getName());
        }

        if (foodNamesList.isEmpty()) {
            throw new ListIsEmptyException("Base are null");
        }

        return foodNamesList;

//        return foodRepository.findAll().stream()
//                .map(Food::getName)
//                .collect(Collectors.toList());
    }


    @Override
    public float getCalories(String name, String weight) throws InputValueValidationException {

        if (foodRepository.findByName(name) == null) {
            throw new InputValueValidationException("Food not found");
        }

        try {
            Float.parseFloat(weight);
        } catch (NumberFormatException e) {
            throw new InputValueValidationException("Invalid input weight");
        }

        return foodRepository.findByName(name).calculateCaloriesByWeight(new Float(weight).floatValue());
    }
}
