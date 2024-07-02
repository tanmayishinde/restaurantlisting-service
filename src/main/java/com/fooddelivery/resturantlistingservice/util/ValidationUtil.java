package com.fooddelivery.resturantlistingservice.util;

import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;

public final class ValidationUtil {
    public static boolean validateRequest(RestaurantRequestVO requestVO){
        boolean isValid;
        if(requestVO.getName() == null){
            isValid = false;
            return isValid;
        }
        if(requestVO.getAddress() == null){
            isValid = false;
            return isValid;
        }
        if(requestVO.getCity()==null){
            isValid = false;
            return isValid;
        }
        isValid = true;
        return isValid;

    }
}
