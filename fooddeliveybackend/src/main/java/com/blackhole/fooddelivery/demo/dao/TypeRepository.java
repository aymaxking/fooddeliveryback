package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByTitle(String title);

}
