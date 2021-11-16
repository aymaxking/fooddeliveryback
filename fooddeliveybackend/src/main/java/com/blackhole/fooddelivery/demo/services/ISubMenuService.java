package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.service.model.SubMenu;

import java.util.List;

public interface ISubMenuService {
    SubMenu getById(Long id);
    List<SubMenu> getAll();
    void create(SubMenu subMenu);
    void update(Long id,SubMenu subMenu);
    void delete(Long id);
}
