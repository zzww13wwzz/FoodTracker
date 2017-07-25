package com.food.clear.service;

import com.food.clear.repository.Food;
import com.food.clear.repository.FoodRepository;
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
    public List<String> getFoodNames() {

        List<String> foodNamesList = new ArrayList<>();

        for (Food food : foodRepository.findAll()) {
            foodNamesList.add(food.getName());
        }
        return foodNamesList;

//        return foodRepository.findAll().stream()
//                .map(Food::getName)
//                .collect(Collectors.toList());
    }

    @Override
    public float getCalories(String name, float weight) {
        return foodRepository.findByName(name).calculateCaloriesByWeight(weight);
    }

}
