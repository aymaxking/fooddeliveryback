package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

    Page<Category> findByTitleContains(String title, Pageable pageable);

    List<Category> findByTitleContains(String title);


}
