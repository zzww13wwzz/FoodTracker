package com.food.food;

/**
 * Created by zzvv13vvzz on 7/20/17.
 */
public class CalculatorCallories {
    public float getCaloriesForNewWeightAndOldParameters(float newWeight, float oldWeight, float caloriesForOldWeight) {
        return ( newWeight * caloriesForOldWeight ) / oldWeight;
    }
}
