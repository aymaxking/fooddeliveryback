package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;

import java.util.List;

public interface ICategoryService {
    CategoryVo getById(Long id);
    List<CategoryVo> getAll();
    void save(CategoryVo category);
    void update(Long id,CategoryVo category);
    void delete(Long id);
}
