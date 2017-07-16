package vv.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vv.food.Calculations;
import vv.food.entity.Item;
import vv.food.repository.ItemRepository;

@RestController
public class ItemController {

    private ItemRepository itemRepository;

    private Calculations calculations = new Calculations();

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value="getCallories")
    public float getInfo(@RequestParam("name") String name, @RequestParam("weight") float weight) {

        Item item = itemRepository.findByName(name);

        return calculations.calculateCaloriesForWeight(weight, item.getWeight(), item.getCalories());

        //example-> http://localhost:8181/getCallories?name=Apple&weight=150
    }

}
