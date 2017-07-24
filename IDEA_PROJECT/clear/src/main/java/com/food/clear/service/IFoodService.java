package com.food.clear.service;

import java.util.List;

public interface IFoodService {

    List <String>getFoodNames();
    float getCalories(String name, float weight);
}
