package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
    SubMenu findByTitle(String title);
    SubMenu findByPrice(double price);

}
