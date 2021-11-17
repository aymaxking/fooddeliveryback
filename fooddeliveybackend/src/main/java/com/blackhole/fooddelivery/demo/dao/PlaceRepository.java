package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByTitle(String title);

}
