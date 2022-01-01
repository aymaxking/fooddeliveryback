package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;
import com.blackhole.fooddelivery.demo.model.ApplicationPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationPlaceRepository extends JpaRepository<ApplicationPlace, Long> {
    Page<ApplicationPlace> findAll(Pageable pageable);

    List<ApplicationPlace> findByNameContainsOrEmailContains(String name, String email);

    Page<ApplicationPlace> findByNameContainsOrEmailContains(String name, String email,Pageable pageable);

}
