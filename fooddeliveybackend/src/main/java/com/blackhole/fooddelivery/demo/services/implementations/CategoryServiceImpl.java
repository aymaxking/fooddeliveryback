package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CategoryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.TypeConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public CategoryVo getById(Long id) {
        boolean trouve = categoryRepository.existsById(id);
        if (!trouve)
            return null;
        return CategoryConverter.toVo(categoryRepository.getOne(id));
    }

    @Override
    public List<CategoryVo> getAll() {
        List<Category> list = categoryRepository.findAll();
        return CategoryConverter.toVoList(list);
    }

    @Override
    public void save(CategoryVo category) {
        categoryRepository.save(CategoryConverter.toBo(category));
    }

    @Override
    public void update(Long id, CategoryVo category) {
        category.setId(id);
        categoryRepository.save(CategoryConverter.toBo(category));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
