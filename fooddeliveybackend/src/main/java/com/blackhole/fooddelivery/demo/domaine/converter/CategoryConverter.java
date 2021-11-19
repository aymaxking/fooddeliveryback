package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryConverter {
    public static CategoryVo toVo(Category bo) {
        if (bo == null)
            return null;
        CategoryVo vo = new CategoryVo();
        vo.setId(bo.getId());
        vo.setTitle(bo.getTitle());
        vo.setTypes(TypeConverter.toVoList(bo.getTypes()));
        return vo;
    }

    public static Category toBo(CategoryVo vo) {
        if (vo == null)
            return null;
        Category bo = new Category();
        bo.setId(vo.getId());
        bo.setTitle(vo.getTitle());
        bo.setTypes(TypeConverter.toBoList(vo.getTypes()));
        return bo;
    }

    public static List<CategoryVo> toVoList(List<Category> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<CategoryVo> voList = new ArrayList<>();
        for (Category category : boList) {
            voList.add(toVo(category));
        }
        return voList;
    }

    public static List<Category> toBoList(List<CategoryVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Category> boList = new ArrayList<>();
        for (CategoryVo categoryVo : voList) {
            boList.add(toBo(categoryVo));
        }
        return boList;

    }
}