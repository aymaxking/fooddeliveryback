package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;

import java.util.List;

public interface ITypeService {
    TypeVo getById(Long id);
    List<TypeVo> getAll();
    void save(TypeVo type);
    void update(Long id,TypeVo type);
    void delete(Long id);
}
