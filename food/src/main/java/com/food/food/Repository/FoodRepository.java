package com.food.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository extends JpaRepository <Food, Long> {
    Food findFoodInfoByName(String name);
//    Food calculateCalloriesByWeight(float weight);
}
