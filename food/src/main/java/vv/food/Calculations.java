package vv.food;

public class Calculations {
    public float calculateCaloriesForWeight(float inputWeight, float weight, float calories) {
        float finalCalories = ( inputWeight * calories ) / weight;
        System.out.println("input" +finalCalories);
        return finalCalories;
    }
}
