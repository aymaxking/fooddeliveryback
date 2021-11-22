package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.TypeConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.model.Type;
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
    public TypeVo getByTitle(String title) {
        TypeVo trouve = TypeConverter.toVo(typeRepository.findByTitle(title));
        if (trouve==null)
            return null;
        return trouve;
    }

    @Override
    public List<TypeVo> getAll() {
        return TypeConverter.toVoList(typeRepository.findAll());    }

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
