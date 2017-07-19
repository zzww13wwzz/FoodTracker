package com.food.food;


import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
    private FoodRepository foodRepository;
    private  CalculatorCallories calculatorCallories;

    public TaskManager (FoodRepository foodRepository, CalculatorCallories calculatorCallories) {
        this.foodRepository = foodRepository;
        this.calculatorCallories = calculatorCallories;
    }

    public List <String> findAllFoodNames() {

        List<String> foodNamesList = new ArrayList<>();

        for (Food food : foodRepository.findAll()) {
            foodNamesList.add(food.getName());
        }
        return foodNamesList;
    }

    public float getCalloriesForFoodWithWeight (String name, float newWeight) {

        Food food = foodRepository.findFoodInfoByName(name);

        return calculatorCallories.getCaloriesForNewWeightAndOldParameters(newWeight, food.getWeight(), food.getCalories());

    }
}

