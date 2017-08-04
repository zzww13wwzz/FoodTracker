package com.food.food.controller;

import com.food.food.service.IFoodService;
import com.food.food.service.exceptions.InputValueValidationException;
import com.food.food.service.exceptions.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<String>> findAllByName() throws ListIsEmptyException {
        try {
            return new ResponseEntity<List<String>>(foodService.getFoodNames(), HttpStatus.OK);
        } catch (ListIsEmptyException e) {
            return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "calories", method = RequestMethod.GET)
    public ResponseEntity<String> getCalories(@RequestParam("foodName") String name,
                                              @RequestParam("foodWeight") String weight) {
        try {
            return new ResponseEntity<String>(new Float(foodService.getCalories(name, weight)).toString(), HttpStatus.OK);
        } catch (InputValueValidationException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

}
