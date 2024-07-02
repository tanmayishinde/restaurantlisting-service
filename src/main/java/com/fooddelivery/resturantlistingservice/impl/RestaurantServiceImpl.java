package com.fooddelivery.resturantlistingservice.impl;

import com.fooddelivery.resturantlistingservice.entity.RestaurantEntity;
import com.fooddelivery.resturantlistingservice.exception.ResourceNotFoundException;
import com.fooddelivery.resturantlistingservice.helper.Mapper;
import com.fooddelivery.resturantlistingservice.repo.RestaurantRepo;
import com.fooddelivery.resturantlistingservice.service.ResturantService;
import com.fooddelivery.resturantlistingservice.util.ValidationUtil;
import com.fooddelivery.resturantlistingservice.vo.GenericResponse;
import com.fooddelivery.resturantlistingservice.vo.PaginationRequestRestaurantVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements ResturantService {
    private final Mapper mapper;
    private RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo, Mapper mapper) {
        this.restaurantRepo = restaurantRepo;
        this.mapper = mapper;
    }

    @Override
    public GenericResponse addRestaurant(RestaurantRequestVO restaurantRequestVO) {
        boolean isValid = ValidationUtil.validateRequest(restaurantRequestVO);
        if (isValid) {
            RestaurantEntity entity = mapper.ResurantVOToEntity(restaurantRequestVO);
            restaurantRepo.save(entity);
            return new GenericResponse(200, "Restaurant Added Successfully!");
        }

        return new GenericResponse(400,"Please check your request!" +
                "Unable to create Restaurant" );

    }

    @Override
    public List<RestaurantResponseVO> display() {
        Optional<List<RestaurantEntity>> entityList =
                Optional.ofNullable(restaurantRepo.findAll());
        return mapper.ListEntityToListVO(entityList.get());

    }

    @Override
    public ResponseEntity<RestaurantResponseVO> fetchRestaurantById(Long Id) {
        RestaurantEntity entity = restaurantRepo.findById(Id).orElseThrow(
                () -> new ResourceNotFoundException("Restaurant", "Id", Id)
        );
        return ResponseEntity.ok(Mapper.ResurantEntityToVO(entity));
    }

    @Override
    public GenericResponse deleteRestaurantById(Long id) {

        RestaurantEntity entity = restaurantRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Restaurant", "Id", id)
        );
        restaurantRepo.deleteById(id);
        return new GenericResponse(200,"Restaurant deleted Successfully!");
    }

    public List<RestaurantResponseVO> paginationSort(PaginationRequestRestaurantVO request) {
        int pageNo = 0;
        int pageSize = request.getPageSize();
        String sortBy = request.getSortBy();

        Sort sort = request.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(request.getSortBy()).ascending() :
                Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<RestaurantEntity> page = restaurantRepo.findAll(pageable);

        List<RestaurantEntity> list = page.getContent();


        return list.stream().map(Mapper::ResurantEntityToVO)
                 .collect(Collectors.toList());

    }


}
