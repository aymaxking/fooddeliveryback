package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.service.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getById(Long id);
    List<Category> getAll();
    void create(Category category);
    void update(Long id,Category category);
    void delete(Long id);
}
