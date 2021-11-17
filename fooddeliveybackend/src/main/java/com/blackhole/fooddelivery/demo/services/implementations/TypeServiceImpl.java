package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.services.ITypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class TypeServiceImpl implements ITypeService {
    @Override
    public TypeVo getById(Long id) {
        return null;
    }

    @Override
    public List<TypeVo> getAllSubTypes() {
        return null;
    }

    @Override
    public void save(TypeVo type) {

    }

    @Override
    public void update(Long id, TypeVo type) {

    }

    @Override
    public void delete(Long id) {

    }
}
