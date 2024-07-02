package com.fooddelivery.resturantlistingservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericResponse {
    private int statusCode;
    private String statusMessage;

}
