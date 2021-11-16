package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.service.model.Category;
import com.blackhole.fooddelivery.demo.services.ICategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private static List<Category> Repo = new ArrayList<>();

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public void create(Category category) {

    }

    @Override
    public void update(Long id, Category category) {

    }

    @Override
    public void delete(Long id) {

    }
}
