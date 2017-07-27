package com.food.clear.service;

import com.food.clear.repository.Food;
import com.food.clear.repository.FoodRepository;
import com.food.clear.service.exceptions.InputValueValidationException;
import com.food.clear.service.exceptions.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            System.out.println("catch");
            throw new InputValueValidationException("Invalid input weight");
        }

        return foodRepository.findByName(name).calculateCaloriesByWeight(new Float(weight).floatValue());
    }
}
