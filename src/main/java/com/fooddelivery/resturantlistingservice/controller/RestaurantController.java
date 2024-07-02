package com.fooddelivery.resturantlistingservice.controller;

import com.fooddelivery.resturantlistingservice.service.ResturantService;
import com.fooddelivery.resturantlistingservice.vo.GenericResponse;
import com.fooddelivery.resturantlistingservice.vo.PaginationRequestRestaurantVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    public ResturantService service;

    @Autowired
    public RestaurantController(ResturantService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public GenericResponse addRestaurant(@RequestBody RestaurantRequestVO restaurantRequestVO) {
        return service.addRestaurant(restaurantRequestVO);
    }
    @GetMapping("/display")
    public List<RestaurantResponseVO> display() {
        return service.display();
    }

    @GetMapping("/fetchRestaurantById")
    public ResponseEntity<RestaurantResponseVO> fetchRestaurantById(@RequestParam("Id") Long Id) {
        return service.fetchRestaurantById(Id);
    }

    @DeleteMapping("/deleteRestaurant")
    public GenericResponse deleteRestaurantById(@RequestParam Long Id) {
        return service.deleteRestaurantById(Id);
    }

    @GetMapping("/getRestaurantByPaging")
    public List<RestaurantResponseVO> paginationSort(@RequestBody PaginationRequestRestaurantVO request){
        return service.paginationSort(request);
    }
}
