package com.food.food.Controller;

import com.food.food.Repository.FoodRepository;
import com.food.food.TaskManager.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class FoodRequestController {



    private FoodRepository foodRepository;

    private Calculations calculations = new Calculations();

    @Autowired
    public FoodRequestController(FoodRepository foodRepository)
    {
        this.foodRepository = foodRepository;
    }


    private TaskManager taskManager = new TaskManager();

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










//    private ItemRepository itemRepository;

//    private Calculations calculations = new Calculations();
//
//    @Autowired
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    @RequestMapping(value="getCallories")
//    public float getInfo(@RequestParam("name") String name, @RequestParam("weight") float weight) {
//
//        Item item = itemRepository.findByName(name);
//
//        return calculations.calculateCaloriesForWeight(weight, item.getWeight(), item.getCalories());
//
//        //example-> http://localhost:8181/getCallories?name=Apple&weight=150
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<String> findAllNames() {
//
//        List<String> findAllNames = new ArrayList<>();
//
//        for (Item item : itemRepository.findAll()) {
//            findAllNames.add(item.getName());
//        }
//
//        System.out.println("!!!!!!!" + findAllNames);
//
//        return findAllNames;
//
//        //example-> http://localhost:8181/
//    }
}
