package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.service.model.Place;

import java.util.List;

public interface IPlaceService {
    Place getById(Long id);
    List<Place> getAll();
    void create(Place place);
    void update(Long id,Place place);
    void delete(Long id);
}
