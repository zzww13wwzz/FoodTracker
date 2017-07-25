package com.food.clear.service;

import com.food.clear.repository.FoodRepository;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class FoodServiceTest {

    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @Before
    public void setUp() throws Exception {
        this.foodService = new FoodService();

    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void getFoodNames() throws Exception {

//        List<String> foodNamesList = foodService.getFoodNames();
//        assertNotNull("not null", foodService.getFoodNames());
//        Assert.assertNotNull("list not null", foodNamesList);

    }

    @Test
    public void getCalories() throws Exception {
//        float actual = foodService.getCalories("Apple", 15);
//        System.out.println(actual);
       // assertEquals(5.25, actual, 0);
//        assertEquals("test name", "Joe", joe.getName());
//        assertEquals(expected, foodService.getCalories());



    }

}