package com.fooddelivery.resturantlistingservice.helper;

import com.fooddelivery.resturantlistingservice.entity.RestaurantEntity;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public  RestaurantEntity ResurantVOToEntity(RestaurantRequestVO resturantVO){
//        RestaurantEntity entity=new RestaurantEntity();
//        entity.setName(resturantVO.getName());
//        entity.setCity(resturantVO.getCity());
//        entity.setAddress(resturantVO.getAddress());
//        entity.setRestaurantDescription(resturantVO.getRestaurantDescription());
        return new RestaurantEntity(resturantVO.getName(),
                resturantVO.getCity(),
                resturantVO.getAddress(),
                resturantVO.getRestaurantDescription());
    }
    public List<RestaurantResponseVO> ListEntityToListVO(List<RestaurantEntity> entityList){
//        List<RestaurantResponseVO> voConvert = new ArrayList<>();
//        for(RestaurantEntity entity:entityList){
//            RestaurantResponseVO vo =  Mapper.ResurantEntityToVO(entity);
//           voConvert.add(vo);
//        }


        return  entityList.stream()
                .map(Mapper::ResurantEntityToVO)
                .collect(Collectors.toList());
    }
    public  static RestaurantResponseVO ResurantEntityToVO(RestaurantEntity entity){
        return new RestaurantResponseVO(
                entity.getRestaurant_Id(),
                entity.getRestaurantName(),
                entity.getRestaurantCity(),
                entity.getRestaurantAddress(),
                entity.getRestaurantDescription()
        );
    }
}
