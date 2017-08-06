package com.food.food.controller;

import com.food.food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @RequestMapping (value = "foodNames", method = RequestMethod.GET)
    public ResponseEntity findAllByName() {
        return  foodService.getFoodNames();
    }

    @RequestMapping(value = "calories", method = RequestMethod.GET)
    public ResponseEntity getCalories(@RequestParam("foodName") String name,
                                      @RequestParam("foodWeight") String weight) {
        return  foodService.getCalories(name, weight);
    }
}
