package com.food.clear.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FoodTest {
    private Food food;

    @Before
    public void setUp() throws Exception {
        this.food = new Food();
        food.setName("Apple");
        food.setId(1);
        food.setCalories(35);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateCaloriesByWeight() throws Exception {
        assertEquals(5.25, food.calculateCaloriesByWeight(15), 0);
    }

    @Test
    public void getId() throws Exception {
        assertEquals("test id", 1, food.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("test name", "Apple", food.getName());
    }

    @Test
    public void getCalories() throws Exception {
        assertEquals(35, food.getCalories(), 0);
    }
}