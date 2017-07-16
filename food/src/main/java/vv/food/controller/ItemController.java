package vv.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vv.food.Calculations;
import vv.food.entity.Item;
import vv.food.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;


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


    @RequestMapping(method = RequestMethod.GET)
    public List<String> findAllNames() {

        List<String> findAllNames = new ArrayList<>();

        for (Item item : itemRepository.findAll()) {
            findAllNames.add(item.getName());
        }

        System.out.println("!!!!!!!" + findAllNames);

        return findAllNames;

        //example-> http://localhost:8181/
    }



}
