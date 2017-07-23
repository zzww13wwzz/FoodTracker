package com.food.clear.Manager;

import com.food.clear.Repository.Food;
import com.food.clear.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements ITaskManager
{
    FoodRepository foodRepository;

    @Autowired
    public TaskManager (FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<String> getFoodNames() {

        List<String> foodNamesList = new ArrayList<>();

        for (Food food : foodRepository.findAll()) {
            foodNamesList.add(food.getName());
        }
        return foodNamesList;
    }

    @Override
    public float getCalories(String name, float weight)
    {
        return foodRepository.findByName(name).calculateCalloriesByWeight(weight);
    }

}
