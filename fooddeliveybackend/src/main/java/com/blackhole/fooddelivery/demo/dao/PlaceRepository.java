package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByTitle(String title);

}
