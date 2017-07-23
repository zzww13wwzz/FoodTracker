package com.food.food;

public class CalculatorCallories {
    public float getCaloriesForNewWeightAndOldParameters(float newWeight, float caloriesForOldWeight) {
        return ( newWeight * caloriesForOldWeight ) / 100;
    }
}
