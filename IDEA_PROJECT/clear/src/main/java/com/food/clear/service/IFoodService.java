package com.food.clear.service;

import com.food.clear.service.exceptions.InputValueValidationException;
import com.food.clear.service.exceptions.ListIsEmptyException;

import java.util.List;

public interface IFoodService {

    List <String>getFoodNames() throws ListIsEmptyException;
    float getCalories(String name, float weight) throws InputValueValidationException;
}
