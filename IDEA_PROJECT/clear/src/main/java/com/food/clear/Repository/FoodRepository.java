package com.food.clear.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
//    Food findAllByNameAndWeight (String name, float);
    Food findByName (String name);
//    public float findAllByNameAndWeight (String name, float weight);
}
