package com.food.food.controller;

import com.food.food.service.IFoodService;
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
    private IFoodService foodService;

    @RequestMapping (value = "foodNames", method = RequestMethod.GET)
    public List<String> findAllByName() {
        return  foodService.getFoodNames();
    }

    @RequestMapping(value = "calories", method = RequestMethod.GET)
    public String getCalories(@RequestParam("foodName") String name,
                              @RequestParam("foodWeight") String weight) {
        return new Float(foodService.getCalories(name, weight)).toString();
    }

}
