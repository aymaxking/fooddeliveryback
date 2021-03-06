package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu> findAll(Pageable pageable);
}
