package com.food.clear.Manager;

import java.util.List;

public interface ITaskManager {
    public List <String>getFoodNames();
    public float getCalories(String name, float weight);
}
