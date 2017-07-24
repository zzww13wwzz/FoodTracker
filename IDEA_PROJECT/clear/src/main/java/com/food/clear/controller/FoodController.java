package com.food.clear.controller;

import com.food.clear.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FoodController {

    @Autowired
    private IFoodService taskManager;
    //http://localhost:8080/app/hello

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, world";
    }

    @RequestMapping (value = "GetAllFoodNames")
    public List<String> findAllByName() {
        return taskManager.getFoodNames();
    }

    @RequestMapping(value = "calories", method = RequestMethod.GET)
    public float getCalories(@RequestParam("foodName") String name,
                              @RequestParam("foodWeight") float weight) {
        return taskManager.getCalories(name, weight);
    }

}
