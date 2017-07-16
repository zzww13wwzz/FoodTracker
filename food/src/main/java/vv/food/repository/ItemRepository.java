package vv.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vv.food.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);

}
