package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Testclass;

import java.util.List;

public interface ICategoryService {
    CategoryVo getById(Long id);
    List<CategoryVo> getAll();
    List<CategoryVo> getAllPagging(int page,int size);
    List<CategoryVo> getAllByTitlte(String title);
    List<CategoryVo> getAllByTitltePagging(String title,int page,int size);
    Testclass test();
    void save(CategoryVo category);
    void update(Long id,CategoryVo category);
    void delete(Long id);
}
