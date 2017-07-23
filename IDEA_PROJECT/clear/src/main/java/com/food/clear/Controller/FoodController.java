package com.food.clear.Controller;

import com.food.clear.Manager.ITaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class FoodController {

    @Autowired
    private ITaskManager taskManager;
    //http://localhost:8080/app/hello

    @RequestMapping(value="hello")
    public String hello() {
        System.out.println("1111111111");
        return "Hello, world";
    }

    @RequestMapping (value = "GetAllFoodNames")
    public List<String> findAllByName() {
        System.out.println("1111111111");
        return taskManager.getFoodNames();
    }

    @RequestMapping(value = "GetCalories")
    public float getCalories(@RequestParam("foodName") String name,
                              @RequestParam("foodWeight") float weight) {
        System.out.println("2222222222222");
        return taskManager.getCalories(name, weight);
    }

}
