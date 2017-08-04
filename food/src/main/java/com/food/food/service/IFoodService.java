package com.food.food.service;

import com.food.food.service.exceptions.InputValueValidationException;
import com.food.food.service.exceptions.ListIsEmptyException;

import java.util.List;

public interface IFoodService {

    List <String>getFoodNames() throws ListIsEmptyException;
    float getCalories(String name, String weight) throws InputValueValidationException;
}
