package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByTitle(String title);

    List<Place> findByUsernameContainsOrTitleContains(String username, String title);

    Page<Place> findByUsernameContainsOrTitleContains(String username, String title,  Pageable pageable);
}
