package com.fooddelivery.resturantlistingservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantResponseVO {
    private Long Id;
    private String Name;
    private String Address;
    private String City;
    private String RestaurantDescription;

    public RestaurantResponseVO(Long id, String name, String city, String address, String restaurantDescription) {
    this.Id = id;
    this.Name = name;
    this.City = city;
    this.Address = address;
    this.RestaurantDescription = restaurantDescription;
    }
}
