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
    public float getCalories(String name, float weight) throws InputValueValidationException {
        if (foodRepository.findByName(name) == null) {
            throw new IllegalArgumentException("Food not found");
        }

        Scanner scanner = new Scanner(System.in);

        try {
            int usrInput=scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new InputValueValidationException("Invalid input weight");
        }

        return foodRepository.findByName(name).calculateCaloriesByWeight(weight);
    }

}
