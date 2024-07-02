package com.fooddelivery.resturantlistingservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationRequestRestaurantVO {
    int pageSize;
    String sortBy;
    String sortDirection;
}
