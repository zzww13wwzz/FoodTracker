package com.food.clear.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private float calories;

    public  float calculateCaloriesByWeight(float weight) {
        return ( getCalories() * weight ) / 100;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

}
