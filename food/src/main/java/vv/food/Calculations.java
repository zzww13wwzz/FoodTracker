package vv.food;

public class Calculations {
    public float calculateCaloriesForWeight(float inputWeight, float weight, float calories) {
        return ( inputWeight * calories ) / weight;
    }
}
