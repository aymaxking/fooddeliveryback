package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.service.model.Menu;

import java.util.List;

public interface IMenuService {
    Menu getById(Long id);
    List<Menu> getAll();
    void create(Menu menu);
    void update(Long id,Menu menu);
    void delete(Long id);
}
