package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.service.model.Type;

import java.util.List;

public interface ITypeService {
    Type getById(Long id);
    List<Type> getAll();
    void create(Type type);
    void update(Long id,Type type);
    void delete(Long id);
}
