package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;
import com.blackhole.fooddelivery.demo.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDeliveryRepository extends JpaRepository<ApplicationDelivery, Long> {
    Page<ApplicationDelivery> findAll(Pageable pageable);

    List<ApplicationDelivery> findByNameContainsOrEmailContains(String name, String email);

    Page<ApplicationDelivery> findByNameContainsOrEmailContains(String name, String email,Pageable pageable);

}
