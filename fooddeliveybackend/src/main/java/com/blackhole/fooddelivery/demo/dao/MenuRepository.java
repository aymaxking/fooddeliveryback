package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByTitle(String title);
}
