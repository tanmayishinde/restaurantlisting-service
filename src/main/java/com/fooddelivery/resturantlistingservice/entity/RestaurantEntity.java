package com.fooddelivery.resturantlistingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Restaurant")
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Restaurant_Id")
    private Long restaurant_Id;

    @Column(name = "RestaurantName")
    private String restaurantName;
    @Column(name = "RestaurantAddress")
    private String restaurantAddress;
    @Column(name = "RestaurantCity")
    private String restaurantCity;
    @Column(name = "RestaurantDescription")
    private String restaurantDescription;
    public RestaurantEntity() {
        // No need to initialize fields here
    }
    public RestaurantEntity(String name,
                            String city,
                            String address,
                            String restaurantDescription) {
    this.restaurantName = name;
    this.restaurantCity=city;
    this.restaurantAddress=address;
    this.restaurantDescription=restaurantDescription;
    }
}
