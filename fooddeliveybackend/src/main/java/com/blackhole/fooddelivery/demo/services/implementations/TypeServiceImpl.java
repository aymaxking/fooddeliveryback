package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CategoryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.TypeConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.service.model.Category;
import com.blackhole.fooddelivery.demo.service.model.Type;
import com.blackhole.fooddelivery.demo.services.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("typeService")
@Transactional
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public TypeVo getById(Long id) {
        boolean trouve = typeRepository.existsById(id);
        if (!trouve)
            return null;
        return TypeConverter.toVo(typeRepository.getOne(id));    }

    @Override
    public List<TypeVo> getAllSubTypes() {
        List<Type> list = typeRepository.findAll();
        return TypeConverter.toVoList(list);    }

    @Override
    public void save(TypeVo type) {
        typeRepository.save(TypeConverter.toBo(type));

    }

    @Override
    public void update(Long id, TypeVo type) {
        type.setId(id);
        typeRepository.save(TypeConverter.toBo(type));
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}
