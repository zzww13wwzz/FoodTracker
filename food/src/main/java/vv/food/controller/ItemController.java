package vv.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import vv.food.Calculations;
import vv.food.entity.Item;
import vv.food.repository.ItemRepository;

import java.util.List;

@RestController
public class ItemController {

    private ItemRepository itemRepository;
    private Calculations calculations;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Item> findAllItems() {
//        System.out.println("!!!!!!!");
//        return itemRepository.findAll();
//    }

    @RequestMapping(value="fetch")
    public float getInfo(@RequestParam("name") String name, @RequestParam("weight") float weight) {
        System.out.println("name:"+ name);
        System.out.println("weight:"+ weight);

        Item item = itemRepository.findByName(name);
        item.getWeight();
        item.getCalories();
        System.out.println(item.getWeight());
        System.out.println(item.getCalories());

        float finalCalories = ( item.getWeight() * item.getCalories() ) / weight;
        System.out.println("input" +finalCalories);

        //float calc = calculations.calculateCaloriesForWeight(30, 100, 50);
        //System.out.println("success" + calc);
        return finalCalories;

        //http://localhost:8181/fetch?id=ID
    }
//    @RequestMapping(value = {"/{name}"})
//    public @ResponseBody Item getAttr(@PathVariable(value="name") String name) {
//        System.out.println("!!!!!!!- name" + name);
//
//        return itemRepository.findByName("Apple");
//
//
////        calculations.calculateCaloriesForWeight()
//        // http://localhost:8181/Apple
//    }

//    @RequestMapping(value = {"/{name}"})
//    public @ResponseBody Item getAttr(@PathVariable(value="weight") String weight) {
//        System.out.println("!!!!!!!- weight" + weight);
//        Item item = itemRepository.findByName("Apple");
//        item.getWeight();
//        item.getCalories();
//        System.out.println(item.getWeight());
//        System.out.println(item.getCalories());
//
//        return itemRepository.findByName("Apple");
//
//
////        calculations.calculateCaloriesForWeight()
//        // http://localhost:8181/Apple
//    }


}
