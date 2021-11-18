package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.Category;
import com.blackhole.fooddelivery.demo.service.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByTitle(String title);
    Page<Category> findByCategoryId(Long categoryId, Pageable pageable);

}
