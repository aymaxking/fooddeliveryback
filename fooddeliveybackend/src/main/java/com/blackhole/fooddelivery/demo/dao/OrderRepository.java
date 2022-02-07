package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
}
