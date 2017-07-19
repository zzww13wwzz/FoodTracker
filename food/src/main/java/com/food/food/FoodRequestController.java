package com.food.food;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodRequestController {

    private TaskManager taskManager;

    public FoodRequestController(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @RequestMapping(value = "GetAllFoodNames")
    public List<String> findFoodNames() {
        return taskManager.findAllFoodNames();
    }

    @RequestMapping(value = "GetCallories")
    public float getCallories(@RequestParam("foodName") String name,
                              @RequestParam("foodWeight") float weight) {
        return taskManager.getCalloriesForFoodWithWeight(name, weight);
    }


}
