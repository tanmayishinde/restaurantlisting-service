package com.fooddelivery.resturantlistingservice.repo;

import com.fooddelivery.resturantlistingservice.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<RestaurantEntity,Long> {
}
