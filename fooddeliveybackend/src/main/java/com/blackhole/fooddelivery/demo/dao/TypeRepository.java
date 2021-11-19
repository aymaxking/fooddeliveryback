package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByTitle(String title);

}
