package com.fooddelivery.resturantlistingservice.service;

import com.fooddelivery.resturantlistingservice.vo.GenericResponse;
import com.fooddelivery.resturantlistingservice.vo.PaginationRequestRestaurantVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ResturantService {
     GenericResponse addRestaurant(RestaurantRequestVO resturantVO);
     List<RestaurantResponseVO> display();

     ResponseEntity<RestaurantResponseVO> fetchRestaurantById(Long Id);

     GenericResponse deleteRestaurantById(Long id);
     public List<RestaurantResponseVO> paginationSort(@RequestBody PaginationRequestRestaurantVO request);
}
