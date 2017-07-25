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
    private IFoodService foodService;
    //http://localhost:8080/app/hello

    @RequestMapping (value = "/foodNames", method = RequestMethod.GET)
    public List<String> findAllByName() {
        return foodService.getFoodNames();
    }

    @RequestMapping(value = "/calories", method = RequestMethod.GET)
    public float getCalories(@RequestParam("foodName") String name,
                              @RequestParam("foodWeight") float weight) {
        return foodService.getCalories(name, weight);
    }

}
