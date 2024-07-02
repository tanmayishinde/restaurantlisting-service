package com.fooddelivery.resturantlistingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//no use in this microservice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExists extends RuntimeException{
    private String message;
    public EmailAlreadyExists(String message){
        super(message);
    }
}
