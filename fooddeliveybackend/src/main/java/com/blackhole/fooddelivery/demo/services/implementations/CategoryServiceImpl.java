package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CategoryConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Testclass;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return CategoryConverter.toVo(categoryRepository.getById(id));
    }

    @Override
    public Testclass test() {
        return new Testclass("this is for test");
    }


    @Override
    public List<CategoryVo> getAll() {
        List<Category> list = categoryRepository.findAll();
        return CategoryConverter.toVoList(list);
    }

    @Override
    public List<CategoryVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Category> list = categoryRepository.findAll(pr).getContent();
        return CategoryConverter.toVoList(list);
    }

    @Override
    public List<CategoryVo> getAllByTitlte(String title) {
        return CategoryConverter.toVoList(categoryRepository.findByTitleContains(title));
    }

    @Override
    public List<CategoryVo> getAllByTitltePagging(String title, int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Category> list = categoryRepository.findByTitleContains(title,pr).getContent();
        return CategoryConverter.toVoList(list);    }

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
