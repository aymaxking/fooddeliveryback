package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
    SubMenu findByTitle(String title);
    SubMenu findByPrice(double price);

}
